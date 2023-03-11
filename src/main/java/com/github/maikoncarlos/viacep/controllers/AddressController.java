package com.github.maikoncarlos.viacep.controllers;

import com.github.maikoncarlos.viacep.controllers.dtos.response.AddressResponseDto;
import com.github.maikoncarlos.viacep.controllers.mappers.AddressControllerMapper;
import com.github.maikoncarlos.viacep.services.AddressService;
import com.github.maikoncarlos.viacep.services.domain.AddressResponseDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping (value = "api/viacep")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;
    private final AddressControllerMapper mapperController;

    @GetMapping (value = "/{cep}")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable ("cep") String zipCode) {
        final AddressResponseDomain responseDomain = this.service.getAddressByZipCode(zipCode);
        return ResponseEntity.ok().body(this.mapperController.toResponseDto(responseDomain));

    }
}
