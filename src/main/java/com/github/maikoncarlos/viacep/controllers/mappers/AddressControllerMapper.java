package com.github.maikoncarlos.viacep.controllers.mappers;

import com.github.maikoncarlos.viacep.controllers.dtos.response.AddressResponseDto;
import com.github.maikoncarlos.viacep.services.domain.AddressResponseDomain;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AddressControllerMapper {
        AddressResponseDto toResponseDto(AddressResponseDomain responseDomain);
}