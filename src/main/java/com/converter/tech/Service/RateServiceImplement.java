package com.converter.tech.Service;

import com.converter.tech.DAO.RateRepository;
import com.converter.tech.Model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImplement implements RateService{
    @Autowired
    RateRepository rateRepository;

    @Override
    public void saveAllRate(Rate rate) {
        rateRepository.save(rate);
    }
}
