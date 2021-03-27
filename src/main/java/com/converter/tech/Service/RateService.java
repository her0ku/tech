package com.converter.tech.Service;

import com.converter.tech.Model.Rate;

import java.time.LocalDate;
import java.util.List;

public interface RateService {
    Rate findFirstByLocalDate(LocalDate date);
    List<Rate> findAllByLocalDate(LocalDate date);
    void saveAllRates(Rate rate);
    List<Rate> getAllRates();
}
