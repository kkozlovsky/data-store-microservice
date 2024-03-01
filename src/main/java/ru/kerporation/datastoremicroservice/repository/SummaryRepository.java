package ru.kerporation.datastoremicroservice.repository;

import ru.kerporation.datastoremicroservice.model.Data;
import ru.kerporation.datastoremicroservice.model.MeasurementType;
import ru.kerporation.datastoremicroservice.model.Summary;
import ru.kerporation.datastoremicroservice.model.SummaryType;

import java.util.Optional;
import java.util.Set;

public interface SummaryRepository {

    Optional<Summary> findBySensorId(final long sensorId,
                                     final Set<MeasurementType> measurementTypes,
                                     final Set<SummaryType> summaryTypes);

    void handle(final Data data);

}