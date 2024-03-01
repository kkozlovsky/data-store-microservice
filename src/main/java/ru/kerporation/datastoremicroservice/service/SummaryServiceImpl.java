package ru.kerporation.datastoremicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.datastoremicroservice.model.Data;
import ru.kerporation.datastoremicroservice.model.MeasurementType;
import ru.kerporation.datastoremicroservice.model.Summary;
import ru.kerporation.datastoremicroservice.model.SummaryType;
import ru.kerporation.datastoremicroservice.model.exception.SensorNotFoundException;
import ru.kerporation.datastoremicroservice.repository.SummaryRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepository summaryRepository;

    @Override
    public Summary get(final Long sensorId,
                       final Set<MeasurementType> measurementTypes,
                       final Set<SummaryType> summaryTypes) {
        return summaryRepository.findBySensorId(sensorId,
                        measurementTypes == null ? Set.of(MeasurementType.values()) : measurementTypes,
                        summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes)
                .orElseThrow(SensorNotFoundException::new);
    }

    @Override
    public void handle(final Data data) {
        summaryRepository.handle(data);
    }

}
