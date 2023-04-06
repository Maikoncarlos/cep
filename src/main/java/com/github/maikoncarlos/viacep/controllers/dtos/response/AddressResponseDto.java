package com.github.maikoncarlos.viacep.controllers.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressResponseDto {

    private String zipcode;
    private String street;
    private String complement;
    private String neighborhood;
    private String locality;
    private String abbreviationCity;

}
