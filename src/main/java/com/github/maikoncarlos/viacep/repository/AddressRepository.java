package com.github.maikoncarlos.viacep.repository;

import com.github.maikoncarlos.viacep.repository.clients.AddressClient;
import com.github.maikoncarlos.viacep.repository.entity.AddressResponseEntity;
import com.github.maikoncarlos.viacep.services.exceptions.ZipcodeNullException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class AddressRepository {
    private final AddressClient client;
    private final AddressRepositoryMapper repositoryMapper;

    public AddressResponseEntity getingAddressByZipcodeInViaCEP(String zipCode) {

        log.info("COMUNICANDO COM API EXTERNA VIACEP");
        log.info("PESQUISA PELO CEP {} ", zipCode);

        try {
            AddressResponseEntity addressEntity = this.client.getingAddressByZipcodeInViaCEP(zipCode);
            log.info("SUCESSO - Retorno {}  : ", addressEntity);
            return this.repositoryMapper.toDomain(addressEntity);
        } catch (
                FeignException.FeignClientException ex) {
            log.error("ERRO - Cep inválido  : " + ex.getMessage());
            throw new ZipcodeNullException("Cep inválido! " + zipCode);
        }

    }
}
