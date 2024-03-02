package ru.kerporation.datastoremicroservice.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.kerporation.datastoremicroservice.model.Data;
import ru.kerporation.datastoremicroservice.model.MeasurementType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
@Slf4j
public class DebeziumEventConsumerImpl implements CDCEventConsumer {

    private final SummaryService summaryService;

    @KafkaListener(topics = "data")
    public void handle(final String message) {
        try {
            final JsonObject payload = JsonParser.parseString(message).getAsJsonObject().get("payload").getAsJsonObject();
            final Data data = new Data();
            data.setId(payload.get("id").getAsLong());
            data.setSensorId(payload.get("sensor_id").getAsLong());
            data.setMeasurement(payload.get("measurement").getAsDouble());
            data.setMeasurementType(MeasurementType.valueOf(payload.get("type").getAsString()));
            data.setTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(payload.get("timestamp").getAsLong() / 1000), TimeZone.getDefault().toZoneId()));
            summaryService.handle(data);
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
