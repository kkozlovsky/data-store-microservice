package ru.kerporation.datastoremicroservice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.kerporation.datastoremicroservice.model.MeasurementType;
import ru.kerporation.datastoremicroservice.model.SummaryEntry;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SummaryDto {

    private long sensorId;
    private Map<MeasurementType, List<SummaryEntry>> values;
}