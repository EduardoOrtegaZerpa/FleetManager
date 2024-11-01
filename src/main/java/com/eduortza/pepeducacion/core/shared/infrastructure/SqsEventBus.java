package com.eduortza.pepeducacion.core.shared.infrastructure;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.application.IEventHandler;
import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqsEventBus implements IEventBus {
    private final AmazonSQS sqsClient = AmazonSQSClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .build();
    private final String queueUrl;
    private final Map<String, List<IEventHandler>> handlers = new HashMap<>();

    public SqsEventBus(String queueUrl) {
        this.queueUrl = queueUrl;
        startPolling();
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        for (DomainEvent event : events) {
            String messageBody = event.toJson();
            SendMessageRequest sendMsgRequest = new SendMessageRequest()
                    .withQueueUrl(queueUrl)
                    .withMessageBody(messageBody);
            sqsClient.sendMessage(sendMsgRequest);
        }
    }

    @Override
    public void subscribe(IEventHandler handler) {
        this.handlers.putIfAbsent(handler.getEventId(), new ArrayList<>());
        this.handlers.get(handler.getEventId()).add(handler);
    }

    private void startPolling() {
        Thread pollingThread = new Thread(() -> {
            while (true) {
                pollMessages();
                try {
                    Thread.sleep(1000); // Espera antes de la siguiente lectura
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        pollingThread.setDaemon(true);
        pollingThread.start();
    }

    private void pollMessages() {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest()
                .withQueueUrl(queueUrl)
                .withMaxNumberOfMessages(10)
                .withWaitTimeSeconds(10);

        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();
        for (Message message : messages) {
            try {
                System.out.println("Procesando mensaje: " + message.getBody());
                DomainEvent event = DomainEvent.fromJson(message.getBody());
                List<IEventHandler> eventHandlers = handlers.get(event.getEventId());
                if (eventHandlers != null) {
                    for (IEventHandler handler : eventHandlers) {
                        handler.handle(event);
                    }
                }
                sqsClient.deleteMessage(queueUrl, message.getReceiptHandle());
            } catch (Exception e) {
                System.err.println("Error procesando el mensaje: " + e.getMessage());
            }
        }
    }
}
