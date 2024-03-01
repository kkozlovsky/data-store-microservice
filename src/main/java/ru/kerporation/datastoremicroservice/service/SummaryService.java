package ru.kerporation.datastoremicroservice.service;

import ru.kerporation.datastoremicroservice.model.Data;
import ru.kerporation.datastoremicroservice.model.MeasurementType;
import ru.kerporation.datastoremicroservice.model.Summary;
import ru.kerporation.datastoremicroservice.model.SummaryType;

import java.util.Set;

public interface SummaryService {

    Summary get(final Long sensorId,
                final Set<MeasurementType> measurementTypes,
                final Set<SummaryType> summaryTypes);

    void handle(final Data data);

}