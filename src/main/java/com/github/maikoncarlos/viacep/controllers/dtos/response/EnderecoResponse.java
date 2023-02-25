package com.github.maikoncarlos.viacep.controllers.dtos.response;

import lombok.Data;

@Data
public class EnderecoResponse {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
