package com.github.maikoncarlos.viacep.clients;

import com.github.maikoncarlos.viacep.services.entities.response.AddressEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCep", url = "${url.openfeing.viacep}")
public interface CadastroClient {

    @GetMapping("${path.openfeing.viacep}")
    AddressEntity getingAddressByZipcodeInViaCEP(@PathVariable("cep") String cep);
}
