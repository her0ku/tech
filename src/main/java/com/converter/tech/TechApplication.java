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
    public static void main(String[] args) {
        SpringApplication.run(TechApplication.class, args);
    }
}
