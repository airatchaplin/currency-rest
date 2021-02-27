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
        return serviceFeignClientCurrency.getToday( app_id, symbols);
    }

    public Currency getAnyDay(String date, String app_id, String symbols) {
        return serviceFeignClientCurrency.getAnyDay(date, app_id, symbols);
    }

}
