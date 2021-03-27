package com.converter.tech.Controller;

import com.converter.tech.DAO.RateRepository;
import com.converter.tech.Model.Currency;
import com.converter.tech.Model.Rate;
import com.converter.tech.Model.XMLData;
import com.converter.tech.Service.ActualRate;
import com.converter.tech.Service.CurrencyService;
import com.converter.tech.Service.RateService;
import com.converter.tech.Service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
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
        model.addAttribute("currency", currencyList);
        model.addAttribute("rate", actualRate);
        return "convertpage";
    }

    @GetMapping("/getAll")
    public String getAllemps() {
        List<Rate> allRates = rateService.getAllRates();
        System.out.println(allRates);
        return "W";
    }
}
