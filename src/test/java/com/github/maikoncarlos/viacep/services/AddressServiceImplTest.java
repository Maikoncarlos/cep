package com.github.maikoncarlos.viacep.services;

import com.github.maikoncarlos.viacep.repository.AddressRepository;
import com.github.maikoncarlos.viacep.repository.AddressSalvedRepository;
import com.github.maikoncarlos.viacep.repository.entity.AddressResponseEntity;
import com.github.maikoncarlos.viacep.services.domain.AddressResponseDomain;
import com.github.maikoncarlos.viacep.services.exceptions.AddressNotFound;
import com.github.maikoncarlos.viacep.services.mapper.AddressServiceMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith (MockitoExtension.class)
@Slf4j
class AddressServiceImplTest {

    public static final String ZIPCODE = "08140060";
    public static final String STREET = "Rua Antonio";
    public static final String NEIGHBORTHOOD = "Itaim Paulista";
    public static final String LOCAIDADE = "Sao Paulo";
    public static final String UF = "SP";
    private static final Long ID = 1L;
    @InjectMocks
    private AddressServiceImpl addressService;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private AddressServiceMapper serviceMapper;
    @Mock
    private AddressSalvedRepository addressSalvedRepository;

    private AddressResponseEntity addressResponseEntity;
    private AddressResponseDomain addressResponseDomain;


    @BeforeEach
    void setUp() {
        addressEntity();
    }


    @Test
    @DisplayName ("deve obter o endereço pelo cep e devolver com sucesso")
    void getAddressByZipCodeWithSucess() {
        when(addressRepository.getingAddressByZipcodeInViaCEP(ZIPCODE)).thenReturn(addressResponseEntity);
        when(serviceMapper.toDomain(addressResponseEntity)).thenReturn(addressResponseDomain);

        AddressResponseDomain responseDomain = assertDoesNotThrow(() -> addressService.getAddressByZipCode(ZIPCODE));

        assertNotNull(responseDomain);
        assertDoesNotThrow(()-> addressRepository.getingAddressByZipcodeInViaCEP(any()));
        assertEquals(ZIPCODE, responseDomain.getZipcode());
        assertEquals(STREET, responseDomain.getStreet());

    }

    @Test
    @DisplayName("deve retornar erro Notfound caso endereço venha nulo")
    void returnNotFoundWhenAddressNull(){
        when(addressRepository.getingAddressByZipcodeInViaCEP(anyString()))
                .thenReturn(AddressResponseEntity.builder().build());

        assertThrows(AddressNotFound.class, ()-> addressService.getAddressByZipCode(anyString()));
    }

    private void addressEntity() {
        addressResponseEntity = new AddressResponseEntity(ID, ZIPCODE, STREET, "", NEIGHBORTHOOD, LOCAIDADE, UF);
        addressResponseDomain = new AddressResponseDomain(ZIPCODE, STREET, "", NEIGHBORTHOOD, LOCAIDADE, UF);
    }
}