package com.airatchaplin.currentrest.service;

import com.airatchaplin.currentrest.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Service
public class ServiceFeignClientCurrencyImpl {

    @Autowired
    ServiceFeignClientCurrency serviceFeignClientCurrency;

    @GetMapping()
    public Currency getToday(String data, String rate) {
        data = String.valueOf(LocalDate.now());
        Currency currency =serviceFeignClientCurrency.getToday(data, rate);
        currency.setData(data);
        return currency;
    }

    @GetMapping()
    public Currency getYesterday( String data,String rate) {
        Currency currency =  serviceFeignClientCurrency.getToday(data, rate);
        currency.setData(data);
        return currency;
    }
}
