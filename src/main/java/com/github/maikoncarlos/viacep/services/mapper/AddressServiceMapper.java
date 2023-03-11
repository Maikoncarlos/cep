package com.github.maikoncarlos.viacep.services.mapper;

import com.github.maikoncarlos.viacep.clients.entity.AddressResponseEntity;
import com.github.maikoncarlos.viacep.services.domain.AddressResponseDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressServiceMapper {
    @Mapping ( target = "locality" , source = "localidade" )
    @Mapping ( target = "abbreviationCity" , source = "uf" )
    AddressResponseDomain toDomain(AddressResponseEntity addressEntity);
}
