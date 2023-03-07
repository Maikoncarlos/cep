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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping(value = "api/viacep")
@Slf4j
public class AddressController {

    @Autowired
    AddressService service;
    @Autowired
    AddressMapper mapper;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable("cep") String cep) throws ExecutionException, InterruptedException {

        final CompletableFuture<AddressEntity> entity =
                CompletableFuture.supplyAsync(() -> this.service.getAddressByZipcode(cep));
        log.info(" RESPONSE DA ASSINCRONO {}  : ", entity);
        final AddressEntity responseEntityAsync = entity.get();
        log.info(" RESPONSE DA DEPOIS DA CONVERSAO PARA OBJETO {}  : ", responseEntityAsync);
        final AddressResponseDto response = this.mapper.entityToDTO(responseEntityAsync);
        log.info(" RETORNO DO MAPPER {}  : ", response);

        return ResponseEntity.ok().body(response);
    }
}
