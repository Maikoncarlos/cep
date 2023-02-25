package com.github.maikoncarlos.viacep.controllers.mappers;

import com.github.maikoncarlos.viacep.controllers.dtos.response.EnderecoResponse;
import com.github.maikoncarlos.viacep.services.entities.response.EnderecoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CadastroMapper {
        EnderecoResponse entityToDTO(EnderecoEntity entity);
}
