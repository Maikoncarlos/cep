package com.github.maikoncarlos.viacep.services.entities.response;

import lombok.Data;

@Data
public class EnderecoEntity {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
