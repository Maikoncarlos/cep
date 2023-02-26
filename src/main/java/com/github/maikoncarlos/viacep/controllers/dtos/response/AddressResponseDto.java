package com.github.maikoncarlos.viacep.controllers.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressResponseDto {


    private String zipcode;

    private String street;
    private String complement;
    private String neighborhood;
    private String locality;
    private String abbreviationCity;
}
