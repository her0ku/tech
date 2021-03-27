package com.converter.tech.Service;

import com.converter.tech.Model.Rate;
import com.converter.tech.Model.XMLData;
import org.springframework.stereotype.Service;

@Service
public class ActualRate {

    public static void addActualDate(RateService rateService)
    {
        XMLData xmlData = XMLService.XMLDataParse();
        for(Rate r : xmlData.getRateList())
        {
            rateService.saveAllRates(r);
        }
    }
}
