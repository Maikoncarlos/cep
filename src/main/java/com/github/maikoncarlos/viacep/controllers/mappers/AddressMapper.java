package com.github.maikoncarlos.viacep.controllers.mappers;

import com.github.maikoncarlos.viacep.controllers.dtos.response.AddressResponseDto;
import com.github.maikoncarlos.viacep.services.entities.response.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
        AddressResponseDto entityToDTO(AddressEntity entity);
}
