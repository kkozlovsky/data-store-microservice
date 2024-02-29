package ru.kerporation.datastoremicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.kerporation.datastoremicroservice.model.Summary;
import ru.kerporation.datastoremicroservice.web.dto.SummaryDto;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto> {
}