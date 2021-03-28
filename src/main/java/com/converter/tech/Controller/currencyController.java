package com.converter.tech.Controller;

import com.converter.tech.DAO.RateRepository;
import com.converter.tech.Model.Buffer;
import com.converter.tech.Model.Currency;
import com.converter.tech.Model.Rate;
import com.converter.tech.Model.XMLData;
import com.converter.tech.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class currencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private RateService rateService;


    @GetMapping("/")
    public String getA(Model model)
    {
        LocalDate actualDate = XMLService.getActualDate();
        LocalDate localDate = rateService.findFirstByLocalDate(XMLService.getActualDate()).getLocalDate();
        System.out.println("Дата из БД - " + localDate + " Актуальная дата из документа - " + actualDate);
        if(!localDate.equals(actualDate))
        {
            ActualRate.addActualDate(rateService);
            System.out.println("Добавление актуального курса валют ");
        }
        List<Currency> currencyList = currencyService.getAllCurrency();
        List<Rate> actualRate = rateService.findAllByLocalDate(actualDate);
        List<Buffer> buff = new ArrayList<>();
        for(int i = 0; i < currencyList.size(); i++)
        {
            buff.add(new Buffer(currencyList.get(i).getCharNode(),currencyList.get(i).getName()
                    ,actualRate.get(i).getCurrentRate(), currencyList.get(i).getNominal()));
            System.out.println(buff.get(i));
        }
        model.addAttribute("bufferList", buff);

        return "convertpage";
    }

    @GetMapping("/getAll")
    public String getAllemps() {
        List<Rate> allRates = rateService.getAllRates();
        System.out.println(allRates);
        return "W";
    }
}
