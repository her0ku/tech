package com.converter.tech.Service;

import com.converter.tech.Model.Currency;
import com.converter.tech.Model.Rate;
import com.converter.tech.Model.XMLData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ActualData {

    public static void addActualDate(RateService rateService)
    {
        XMLData xmlData = XMLService.XMLDataParse();
        for(Rate r : xmlData.getRateList())
        {
            rateService.saveAllRates(r);
        }
    }

    public static void addActualCurrency(CurrencyService currencyService)
    {
        XMLData xmlData = XMLService.XMLDataParse();
        for(Currency c : xmlData.getCurrencyList())
        {
            currencyService.saveAllCurrency(c);
        }
    }

    //Получаю актуальную дату
    public static LocalDate getActualDate(RateService rateService, CurrencyService service)
    {
        LocalDate actualDate = XMLService.getActualDate();
        LocalDate localDate;
        if(rateService.findFirstByLocalDate(XMLService.getActualDate()) == null)
        {
            localDate = null;
            ActualData.addActualDate(rateService);
        }
        else
        {
            localDate = rateService.findFirstByLocalDate(XMLService.getActualDate()).getLocalDate();
        }
        if (localDate == null)
        {
            localDate = actualDate;
            ActualData.addActualCurrency(service);
        }
        else if(!localDate.equals(actualDate))
        {
            ActualData.addActualDate(rateService);
        }
        return localDate;
    }
}
