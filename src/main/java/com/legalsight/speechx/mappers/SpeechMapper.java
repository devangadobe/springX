package com.legalsight.speechx.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.legalsight.speechx.dto.SpeechDto;
import com.legalsight.speechx.model.Speech;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpeechMapper {

    SpeechMapper INSTANCE = Mappers.getMapper(SpeechMapper.class);

    SpeechDto modelToDto(Speech speech);

    List<SpeechDto> modelsToDtos(List<Speech> speeches);

    @InheritInverseConfiguration
    Speech dtoToModel(SpeechDto speechDto);
}
