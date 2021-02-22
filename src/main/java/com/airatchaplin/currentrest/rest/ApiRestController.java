package com.airatchaplin.currentrest.rest;

import com.airatchaplin.currentrest.model.Currency;
import com.airatchaplin.currentrest.service.ServiceFeignClientCurrencyImpl;
import com.airatchaplin.currentrest.service.ServiceFeignClientGif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiRestController {

    @Autowired
    ServiceFeignClientCurrencyImpl serviceFeignClientCurrency;

    @Autowired
    ServiceFeignClientGif serviceFeignClientGif;

    @Value("${currency}")
    String currency;

    @Value("${data}")
    String data;

    @GetMapping("/")
    public Object getModel(){
        Currency currencyToday = serviceFeignClientCurrency.getToday(data, currency);
        Currency currencyAnyDay = serviceFeignClientCurrency.getYesterday(data, currency);

        Map<String,Double> mapAnyDay = currencyAnyDay.getRates();
        Map<String,Double> mapToday = currencyToday.getRates();
        Object gif=null;
        if (mapToday.get(currency)>mapAnyDay.get(currency)){
            gif= serviceFeignClientGif.getGifRich();
        }else {
            gif=serviceFeignClientGif.getGifBroke();
        }
        return gif;
    }


}
