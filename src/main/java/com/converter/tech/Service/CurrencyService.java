package com.converter.tech.Service;

import com.converter.tech.Model.Currency;

import java.util.List;

public interface CurrencyService {
    void addAllCurrency(Currency currency);
    List<Currency> getAllCurrency();
}
