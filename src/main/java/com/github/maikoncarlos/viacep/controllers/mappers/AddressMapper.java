package com.github.maikoncarlos.viacep.controllers.mappers;

import com.github.maikoncarlos.viacep.controllers.dtos.response.AddressResponseDto;
import com.github.maikoncarlos.viacep.services.entities.response.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

        AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

        @Mapping ( source = "localidade" , target = "locality" )
        @Mapping ( source = "uf" , target = "abbreviationCity" )
        AddressResponseDto entityToDTO(AddressEntity entity);
}
