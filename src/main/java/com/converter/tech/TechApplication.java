package com.converter.tech;

import com.converter.tech.Model.Currency;
import com.converter.tech.Model.Rate;
import com.converter.tech.Model.XMLData;
import com.converter.tech.Service.CurrencyService;
import com.converter.tech.Service.RateService;
import com.converter.tech.Service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class TechApplication{
/*
    @Autowired
    RateService rateService;

    @Autowired
    CurrencyService currencyService;
*/
    public static void main(String[] args) {
        SpringApplication.run(TechApplication.class, args);
    }
/*
    @Override
    public void run(ApplicationArguments args) throws Exception {
        XMLData xmlData = XMLService.XMLDataParse();
        for(Rate r : xmlData.getRateList())
        {
            rateService.saveAllRates(r);
        }
        for(Currency c : xmlData.getCurrencyList())
        {
            currencyService.addAllCurrency(c);
        }
    }*/
}
