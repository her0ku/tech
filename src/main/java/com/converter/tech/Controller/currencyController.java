package com.converter.tech.Controller;

import com.converter.tech.Model.*;
import com.converter.tech.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class currencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private RateService rateService;

    @Autowired
    private HistoryService historyService;

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }


    @GetMapping("/convert")
    public String getA(Model model)
    {
        LocalDate localDate = ActualData.getActualDate(rateService,currencyService);
        List<Currency> currencyList = currencyService.getAllCurrency();
        if(currencyList.isEmpty())
        {
            ActualData.addActualCurrency(currencyService);
        }
        List<Rate> actualRate = rateService.findAllByLocalDate(localDate);
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

    @PostMapping("/history")
    public void create(@RequestBody History history)
    {
        System.out.println(history);
        historyService.saveHistory(new History(history.getRateFrom(),history.getRateTo(),history.getBaseSum(),
                history.getCurrentSum(), XMLService.getActualDate()));
    }

    @GetMapping("/history")
    public String getAllHistory(Model model)
    {
        List<History> historyList = historyService.getAllHistory();
        model.addAttribute("history", historyList);
        return "history";
    }
}
