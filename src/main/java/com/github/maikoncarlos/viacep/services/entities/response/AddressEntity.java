package com.github.maikoncarlos.viacep.services.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressEntity {
    @JsonProperty (value = "cep")
    private String zipcode;
    @JsonProperty(value = "logradouro")
    private String street;
    @JsonProperty(value = "complemento")
    private String complement;
    @JsonProperty(value = "bairro")
    private String neighborhood;
    private String localidade;
    private String uf;
}
