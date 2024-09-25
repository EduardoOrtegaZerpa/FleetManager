package com.eduortza.pepeducacion.core.shared.domain;

import lombok.Getter;

@Getter
public class Result<T> {
    private final T value;
    private final boolean success;
    private final String errorMessage;

    private Result(T value, boolean success, String errorMessage) {
        this.value = value;
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value, true, null);
    }

    public static <T> Result<T> failure(String errorMessage) {
        return new Result<>(null, false, errorMessage);
    }

}