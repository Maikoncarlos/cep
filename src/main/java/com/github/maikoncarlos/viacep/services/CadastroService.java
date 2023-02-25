package com.github.maikoncarlos.viacep.services;

import com.github.maikoncarlos.viacep.clients.CadastroClient;
import com.github.maikoncarlos.viacep.controllers.dtos.response.EnderecoResponse;
import com.github.maikoncarlos.viacep.services.entities.response.EnderecoEntity;
import com.github.maikoncarlos.viacep.services.exceptions.CepNullException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@Slf4j
public class CadastroService {

    @Autowired
    CadastroClient client;

    public EnderecoEntity buscarEnderecoPeloCep(String cep) {

        log.info("COMUNICANDO COM API EXTERNA VIACEP");
        log.info("PESQUISA PELO CEP {} ", cep);

        try {
            EnderecoEntity enderecoEntity = client.buscarEnderecoPeloCep(cep);
            log.info("SUCESSO - RETORNO {}  : ", enderecoEntity);
            return enderecoEntity;
        } catch (FeignException.FeignClientException ex) {
            log.error("Cep inválido  : " + ex.getMessage());
            throw new CepNullException("Cep inválido! {} ", cep);
        }
    }
}
