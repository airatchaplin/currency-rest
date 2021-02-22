package com.airatchaplin.currencyrest.rest;

import com.airatchaplin.currencyrest.model.Currency;
import com.airatchaplin.currencyrest.service.ServiceCurrency;
import com.airatchaplin.currencyrest.service.ServiceFeignClientGif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiRestController {

    @Autowired
    ServiceCurrency serviceCurrent;

    @Autowired
    ServiceFeignClientGif serviceFeignClientGif;

    @Value("${currency}")
    String currency;

    @Value("${data}")
    String data;

    @GetMapping("/")
    public Object getResponseAtGif(){
        Currency currencyToday = serviceCurrent.getToday(currency);
        Currency currencyAnyDay = serviceCurrent.getAnyDay(data, currency);

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
