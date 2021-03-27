package com.converter.tech.Service;

import com.converter.tech.DAO.CurrencyRepository;
import com.converter.tech.Model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public void addAllCurrency(Currency currency) {
        currencyRepository.save(currency);
    }

    @Override
    public List<Currency> getAllCurrency() {
        return currencyRepository.findAll();
    }
}
