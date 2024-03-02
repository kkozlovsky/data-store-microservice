package ru.kerporation.datastoremicroservice.service;

public interface CDCEventConsumer {
    void handle(final String message);
}