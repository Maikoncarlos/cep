package com.github.maikoncarlos.viacep.services;

import com.github.maikoncarlos.viacep.clients.CadastroClient;
import com.github.maikoncarlos.viacep.services.entities.response.AddressEntity;
import com.github.maikoncarlos.viacep.services.exceptions.ZipcodeNullException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressService {

    @Autowired
    CadastroClient client;

    public AddressEntity getAddressByZipcode(String cep) {

        log.info("COMUNICANDO COM API EXTERNA VIACEP");
        log.info("PESQUISA PELO CEP {} ", cep);

        try {
            AddressEntity enderecoEntity = this.client.getingAddressByZipcodeInViaCEP(cep);
            log.info("SUCESSO - RETORNO {}  : ", enderecoEntity);
            return enderecoEntity;
        } catch (FeignException.FeignClientException ex) {
            log.error("Cep inválido  : " + ex.getMessage());
            throw new ZipcodeNullException("Cep inválido! " + cep);
        }
    }
}
