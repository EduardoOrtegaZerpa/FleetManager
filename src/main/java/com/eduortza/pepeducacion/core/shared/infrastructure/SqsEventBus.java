package com.eduortza.pepeducacion.core.shared.infrastructure;

import com.amazonaws.regions.Regions;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.application.IEventHandler;
import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.Message;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class SqsEventBus implements IEventBus {
    private final AmazonSQS sqsClient = AmazonSQSClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
    .build();
    private final String queueUrl; // URL de la cola en Amazon SQS
    private final Map<String, List<IEventHandler>> handlers = new HashMap<>();

    public SqsEventBus(String queueUrl) {
        this.queueUrl = queueUrl;
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

    public void pollMessages() {
        List<Message> messages = sqsClient.receiveMessage(queueUrl).getMessages();
        for (Message message : messages) {
            DomainEvent event = DomainEvent.fromJson(message.getBody());
            List<IEventHandler> eventHandlers = handlers.get(event.getEventId());
            if (eventHandlers != null) {
                for (IEventHandler handler : eventHandlers) {
                    handler.handle(event);
                }
            }
            sqsClient.deleteMessage(queueUrl, message.getReceiptHandle());
        }
    }
}