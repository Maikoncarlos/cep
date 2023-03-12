package com.github.maikoncarlos.viacep.services;

import com.github.maikoncarlos.viacep.repository.AddressRepository;
import com.github.maikoncarlos.viacep.repository.AddressSalvedRepository;
import com.github.maikoncarlos.viacep.repository.entity.AddressResponseEntity;
import com.github.maikoncarlos.viacep.services.domain.AddressResponseDomain;
import com.github.maikoncarlos.viacep.services.mapper.AddressServiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;
    private final AddressServiceMapper serviceMapper;

    private final AddressSalvedRepository salvedRepository;

    public AddressResponseDomain getAddressByZipCode(final String zipCode) {
        AddressResponseEntity responseEntity = this.addressRepository.getingAddressByZipcodeInViaCEP(zipCode);
        log.info("Salvando endereço no Banco de Dados");
        salvedAddress(responseEntity);

        return this.serviceMapper.toDomain(responseEntity);

    }

    private void salvedAddress(AddressResponseEntity responseEntity) {

        this.salvedRepository.save(responseEntity);
        log.info("Endereço salvado no Banco de Dados!");

    }
}
