package com.converter.tech.Service;

import com.converter.tech.Model.Currency;

import java.util.List;

public interface CurrencyService {
    void saveAllCurrency(Currency currency);
    List<Currency> getAllCurrency();


}
