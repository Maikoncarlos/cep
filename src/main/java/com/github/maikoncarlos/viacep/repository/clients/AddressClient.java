package com.github.maikoncarlos.viacep.repository.clients;

import com.github.maikoncarlos.viacep.repository.entity.AddressResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCep", url = "${url.openfeing.viacep}")
public interface AddressClient {

    @GetMapping("${path.openfeing.viacep}")
    AddressResponseEntity getingAddressByZipcodeInViaCEP(@PathVariable("cep") String zipCode );
}
