package com.github.maikoncarlos.viacep.repository;

import com.github.maikoncarlos.viacep.repository.entity.AddressResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressSalvedRepository extends JpaRepository<AddressResponseEntity, Long> {
}
