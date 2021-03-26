package com.converter.tech.Service;

import com.converter.tech.DAO.CurrencyRepository;
import com.converter.tech.Model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class currencyServiceImplement implements CurrencyService{
    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public void saveAllData(Currency currency) {
        currencyRepository.save(currency);
    }
}
