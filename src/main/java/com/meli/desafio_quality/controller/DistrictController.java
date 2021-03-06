package com.meli.desafio_quality.controller;

import com.meli.desafio_quality.model.District;
import com.meli.desafio_quality.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping()
    public ResponseEntity<District> createDistrict(@RequestBody @Valid District district) {
        return ResponseEntity.status(HttpStatus.CREATED).body(districtService.createDistrict(district));
    }

    @GetMapping("/{districtName}")
    public ResponseEntity<District> getDistrictByName(@PathVariable String districtName) {
        return ResponseEntity.ok(districtService.getDistrictByName(districtName));
    }
}
