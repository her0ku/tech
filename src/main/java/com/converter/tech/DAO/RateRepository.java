package com.converter.tech.DAO;

import com.converter.tech.Model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RateRepository extends JpaRepository<Rate, String> {
    Rate findFirstByLocalDate(LocalDate date);
    List<Rate> findAllByLocalDate(LocalDate date);
}
