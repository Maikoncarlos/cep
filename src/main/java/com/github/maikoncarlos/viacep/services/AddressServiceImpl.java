package com.github.maikoncarlos.viacep.services;

import com.github.maikoncarlos.viacep.clients.CadastroClient;
import com.github.maikoncarlos.viacep.clients.entity.AddressResponseEntity;
import com.github.maikoncarlos.viacep.services.domain.AddressResponseDomain;
import com.github.maikoncarlos.viacep.services.exceptions.ZipcodeNullException;
import com.github.maikoncarlos.viacep.services.mapper.AddressServiceMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService{
    private final CadastroClient client;
    private final AddressServiceMapper serviceMapper;

    public AddressResponseDomain getAddressByZipCode(final String zipCode) {

        log.info("COMUNICANDO COM API EXTERNA VIACEP");
        log.info("PESQUISA PELO CEP {} ", zipCode);

        try {
            AddressResponseEntity addressEntity = this.client.getingAddressByZipcodeInViaCEP(zipCode);
            log.info("SUCESSO - Retorno {}  : ", addressEntity);
            return this.serviceMapper.toDomain(addressEntity);
        } catch (FeignException.FeignClientException ex) {
            log.error("ERRO - Cep inválido  : " + ex.getMessage());
            throw new ZipcodeNullException("Cep inválido! " + zipCode);
        }
    }
}
