package com.meli.desafio_quality.repository;


import com.meli.desafio_quality.exception.DistrictAlreadyExist;
import com.meli.desafio_quality.model.District;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.meli.desafio_quality.util.UtilDistrict.allDistricts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DistrictRepositoryTest {

    private DistrictRepository districtRepository;

    @BeforeEach
    void setup() {
        districtRepository = new DistrictRepository();
    }

    @Test
    void createDistrict_whenNewDistrict() {
        District newDistrict = allDistricts().get(0);

        District createdDistrict = districtRepository.createDistrict(newDistrict);

        assertThat(createdDistrict).isNotNull();
        assertThat(createdDistrict.getDistrictName())
                .isEqualTo(newDistrict.getDistrictName());
    }

    @Test
    void createDistrict_throwException_whenDistrictAlreadyExists() {
        District district = allDistricts().get(0);
        districtRepository.createDistrict(district);
        DistrictAlreadyExist exception = Assertions.assertThrows(DistrictAlreadyExist.class, () -> {
            District createdDistrict = districtRepository.createDistrict(district);
        });

        assertThat(exception.getMessage()).isEqualTo("Bairro já cadastrado");
    }

    @Test
    void getDistrictByName() {
        District district = allDistricts().get(0);
        districtRepository.createDistrict(district);

        District foundDistrict = districtRepository.getDistrictByName(district.getDistrictName());
        Assertions.assertNotNull(foundDistrict.getDistrictName());
        Assertions.assertNotNull(foundDistrict.getValueDistrictM2());
        org.assertj.core.api.Assertions.assertThat(foundDistrict).isEqualTo(allDistricts().get(0));
    }

    @Test
    void notFoundDistrictByName() {
        String name = "nome que não existe no BD";
        District response = null;
        Exception testException = null;
        try {
            response = districtRepository.getDistrictByName(name);
        } catch (Exception exception) {
            testException = exception;
        }
        Assertions.assertNull(response);
        org.assertj.core.api.Assertions.assertThat(testException.getMessage()).isEqualTo("Bairro não encontrado em nosso BD.");
    }

}