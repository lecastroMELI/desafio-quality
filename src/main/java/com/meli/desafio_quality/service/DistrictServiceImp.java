package com.meli.desafio_quality.service;

import com.meli.desafio_quality.model.District;
import com.meli.desafio_quality.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImp implements DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public District createDistrict(District district) {
        return districtRepository.createDistrict(district);
    }

    @Override
    public District getDistrictByName(String name) {
        return districtRepository.getDistrictByName(name);
    }
}
