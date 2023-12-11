package com.example.Diplom.repository;

import com.example.Diplom.model.CustomsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomsDataRepository extends JpaRepository<CustomsData, Long> {
    // Дополнительные методы, если необходимо
}
