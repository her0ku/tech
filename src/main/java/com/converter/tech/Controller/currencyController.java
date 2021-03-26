package com.converter.tech.Controller;

import com.converter.tech.DAO.RateRepository;
import com.converter.tech.Model.Currency;
import com.converter.tech.Model.Rate;
import com.converter.tech.Model.XMLData;
import com.converter.tech.Service.CurrencyService;
import com.converter.tech.Service.RateService;
import com.converter.tech.Service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class currencyController {
    @Autowired
    CurrencyService currencyService;

    @Autowired
    RateService rateService;

    @GetMapping("/Convert")
    public String getСConvert() {
        XMLData xmlData = XMLService.XMLDataParse();
        System.out.println("\n\n\n\n\nПАРСЕР");
        for(Currency currency: xmlData.getCurrencyList())
        {
            System.out.println(currency);
            currencyService.saveAllData(currency);
        }
        for(Rate rate: xmlData.getRateList())
        {
            rateService.saveAllRate(rate);
        }
        return "ass";
    }
}
