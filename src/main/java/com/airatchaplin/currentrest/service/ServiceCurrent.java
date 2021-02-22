package com.airatchaplin.currentrest.service;

import com.airatchaplin.currentrest.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Service
public class ServiceCurrent {

    @Autowired
    ServiceFeignClientCurrency serviceFeignClientCurrency;


    public Currency getToday(String rate) {
        String data = String.valueOf(LocalDate.now());
        Currency currency =serviceFeignClientCurrency.getToday(data, rate);
        currency.setData(data);
        return currency;
    }

    public Currency getAnyDay( String data,String rate) {
        Currency currency =  serviceFeignClientCurrency.getAnyDay(data, rate);
        currency.setData(data);
        return currency;
    }
}
