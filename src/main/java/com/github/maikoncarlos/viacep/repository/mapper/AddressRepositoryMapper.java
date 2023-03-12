package com.github.maikoncarlos.viacep.repository.mapper;

import com.github.maikoncarlos.viacep.repository.entity.AddressResponseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressRepositoryMapper {


    AddressResponseEntity toDomain(AddressResponseEntity addressEntity);
}
