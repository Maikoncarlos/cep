package com.github.maikoncarlos.viacep.services.domain;

import lombok.Data;

@Data
public class AddressResponseDomain {

    private String zipcode;
    private String street;
    private String complement;
    private String neighborhood;
    private String locality;
    private String abbreviationCity;
}
