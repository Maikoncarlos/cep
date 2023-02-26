package com.github.maikoncarlos.viacep.controllers;

import com.github.maikoncarlos.viacep.controllers.dtos.response.AddressResponseDto;
import com.github.maikoncarlos.viacep.controllers.mappers.AddressMapper;
import com.github.maikoncarlos.viacep.services.AddressService;
import com.github.maikoncarlos.viacep.services.entities.response.AddressEntity;
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
public class AddressController {

    @Autowired
    AddressService service;
    @Autowired
    AddressMapper mapper;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable("cep") String cep){
        AddressEntity entity = this.service.getAddressByZipcode(cep);
        AddressResponseDto response = this.mapper.entityToDTO(entity);
        log.info(" RETORNO DO MAPPER {}  : ", response);
        return ResponseEntity.ok().body(response);
    }
}
