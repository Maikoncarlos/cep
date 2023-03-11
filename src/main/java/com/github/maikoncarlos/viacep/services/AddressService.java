package com.github.maikoncarlos.viacep.services;

import com.github.maikoncarlos.viacep.services.domain.AddressResponseDomain;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    AddressResponseDomain getAddressByZipCode(final String zipCode);

}
