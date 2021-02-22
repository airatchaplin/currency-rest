package com.airatchaplin.currencyrest.service;

import com.airatchaplin.currencyrest.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ServiceCurrency {

    @Autowired
    ServiceFeignClientCurrency serviceFeignClientCurrency;

    public Currency getToday(String app_id, String symbols) {
        String date = String.valueOf(LocalDate.now());
        Currency currencyToday = serviceFeignClientCurrency.getToday(date, app_id, symbols);
        currencyToday.setDate(date);
        return currencyToday;
    }

    public Currency getAnyDay(String date, String app_id, String symbols) {
        Currency currencyAnyDay = serviceFeignClientCurrency.getAnyDay(date, app_id, symbols);
        currencyAnyDay.setDate(date);
        return currencyAnyDay;
    }

}
