package com.github.maikoncarlos.viacep.controllers;

import com.github.maikoncarlos.viacep.controllers.dtos.response.EnderecoResponse;
import com.github.maikoncarlos.viacep.controllers.mappers.CadastroMapper;
import com.github.maikoncarlos.viacep.services.CadastroService;
import com.github.maikoncarlos.viacep.services.entities.response.EnderecoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/viacep")
@Slf4j
public class CadastroController {

    @Autowired
    CadastroService service;
    @Autowired
    CadastroMapper mapper;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<EnderecoResponse> buscarEndereco(@PathVariable("cep") String cep){
        EnderecoEntity entity = service.buscarEnderecoPeloCep(cep);
        EnderecoResponse response = mapper.entityToDTO(entity);
        return ResponseEntity.ok().body(response);
    }
}
