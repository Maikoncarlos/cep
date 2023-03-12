package com.github.maikoncarlos.viacep.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
