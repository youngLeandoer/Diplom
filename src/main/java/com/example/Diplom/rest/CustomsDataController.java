package com.example.Diplom.rest;

import com.example.Diplom.model.CustomsData;
import com.example.Diplom.repository.CustomsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customs")
public class CustomsDataController {
    private final CustomsDataRepository customsDataRepository;

    @Autowired
    public CustomsDataController(CustomsDataRepository customsDataRepository) {
        this.customsDataRepository = customsDataRepository;
    }

    @GetMapping
    public List<CustomsData> getAllCustomsData() {
        return customsDataRepository.findAll();
    }

    @PostMapping
    public CustomsData addCustomsData(@RequestBody CustomsData customsData) {
        return customsDataRepository.save(customsData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomsData> getCustomsDataById(@PathVariable Long id) {
        Optional<CustomsData> customsData = customsDataRepository.findById(id);
        return customsData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
