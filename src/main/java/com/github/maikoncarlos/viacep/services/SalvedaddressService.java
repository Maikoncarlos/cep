package com.github.maikoncarlos.viacep.services;

import com.github.maikoncarlos.viacep.repository.AddressSalvedRepository;
import com.github.maikoncarlos.viacep.repository.entity.AddressResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
class SalvedAddressService {
    private final AddressSalvedRepository salvedRepository;

    void salvedAddress(AddressResponseEntity responseEntity) {
        this.salvedRepository.save(responseEntity);
        log.info("Endereço salvo no Banco de Dados!");
    }
}
