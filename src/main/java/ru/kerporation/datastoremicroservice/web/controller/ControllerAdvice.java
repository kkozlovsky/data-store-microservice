package ru.kerporation.datastoremicroservice.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kerporation.datastoremicroservice.model.exception.SensorNotFoundException;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(SensorNotFoundException.class)
    public String sensorNotFound(final SensorNotFoundException ignored) {
        return "Sensor not found.";
    }

    @ExceptionHandler
    public String server(final Exception e) {
        log.error(e.getMessage(), e);
        return "Something happened.";
    }

}