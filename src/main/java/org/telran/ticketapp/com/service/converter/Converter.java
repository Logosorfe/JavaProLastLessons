package org.telran.ticketapp.com.service.converter;

public interface Converter<Entity, Dto, CreateDto> {

    Entity toEntity(CreateDto dto);

    Dto toDto(Entity entity);

}
