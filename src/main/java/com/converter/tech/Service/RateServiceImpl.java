package com.converter.tech.Service;

import com.converter.tech.DAO.RateRepository;
import com.converter.tech.Model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RateServiceImpl implements RateService{
    @Autowired
    private RateRepository rateRepository;


    @Override
    public Rate findFirstByLocalDate(LocalDate date) {
        Rate baseDate = null;
        Optional<Rate> optionalRate = Optional.ofNullable(rateRepository.findFirstByLocalDate(date));
        if(optionalRate.isPresent())
        {
            baseDate = optionalRate.get();
        }
        return baseDate;
    }

    @Override
    public List<Rate> findAllByLocalDate(LocalDate date) {
        return rateRepository.findAllByLocalDate(date);
    }


    @Override
    public void saveAllRates(Rate rate) {
        rateRepository.save(rate);
    }

    @Override
    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }
}
