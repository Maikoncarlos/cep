package com.github.maikoncarlos.viacep.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AddressResponseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column (name = "id", nullable = false)
    private Long id;

    @JsonProperty("cep")
    private String zipcode;
    @JsonProperty("logradouro")
    private String street;
    @JsonProperty("complemento")
    private String complement;
    @JsonProperty("bairro")
    private String neighborhood;
    private String localidade;
    private String uf;

}
