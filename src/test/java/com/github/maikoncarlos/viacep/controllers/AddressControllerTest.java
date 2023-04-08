package com.github.maikoncarlos.viacep.controllers;

import com.github.maikoncarlos.viacep.controllers.dtos.response.AddressResponseDto;
import com.github.maikoncarlos.viacep.controllers.mappers.AddressControllerMapper;
import com.github.maikoncarlos.viacep.services.AddressService;
import com.github.maikoncarlos.viacep.services.domain.AddressResponseDomain;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith (MockitoExtension.class)
@Slf4j
class AddressControllerTest {

    public static final String ZIPCODE = "08140060";
    public static final String STREET = "Rua Antonio";
    public static final String NEIGHBORTHOOD = "Itaim Paulista";
    public static final String LOCALITY = "Sao Paulo";
    public static final String ABREVIATIONCITY = "SP";

    @InjectMocks
    private AddressController addressController;
    @Mock
    private AddressService service;
    @Mock
    private AddressControllerMapper mapperController;

    private AddressResponseDomain responseDomain;
    private AddressResponseDto responseDto;

    @BeforeEach
    void setup() {
        address();
    }

    @Test
    @DisplayName ("deve buscar endereço com sucesso")
    void mustGetAddreddWithSucess() {

        when(this.service.getAddressByZipCode(anyString())).thenReturn(responseDomain);
        when(this.mapperController.toResponseDto(responseDomain)).thenReturn(responseDto);

        ResponseEntity<AddressResponseDto> responseDto = addressController.getAddress(ZIPCODE);

        log.info("responseDTO:  {} ", responseDto);

        assertNotNull(responseDto);
        assertEquals(HttpStatus.OK, responseDto.getStatusCode());
        assertEquals(ZIPCODE, Objects.requireNonNull(responseDto.getBody()).getZipcode());
        assertEquals(STREET, Objects.requireNonNull(responseDto.getBody()).getStreet());
        assertEquals(NEIGHBORTHOOD, Objects.requireNonNull(responseDto.getBody()).getNeighborhood());
        assertEquals(LOCALITY, Objects.requireNonNull(responseDto.getBody()).getLocality());
        assertEquals(ABREVIATIONCITY, Objects.requireNonNull(responseDto.getBody()).getAbbreviationCity());
        assertEquals("", Objects.requireNonNull(responseDto.getBody()).getComplement());
        assertDoesNotThrow(()-> addressController.getAddress(ZIPCODE));


    }

    private void address() {
        responseDomain = new AddressResponseDomain(ZIPCODE, STREET, "", NEIGHBORTHOOD, LOCALITY, ABREVIATIONCITY);
        responseDto = new AddressResponseDto(ZIPCODE, STREET, "", NEIGHBORTHOOD, LOCALITY, ABREVIATIONCITY);
    }

}