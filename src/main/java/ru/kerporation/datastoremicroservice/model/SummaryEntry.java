package ru.kerporation.datastoremicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SummaryEntry {

    private SummaryType type;
    private double value;
    private long counter;

}
