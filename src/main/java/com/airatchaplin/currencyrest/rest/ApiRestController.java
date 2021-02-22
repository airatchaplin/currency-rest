package com.airatchaplin.currencyrest.rest;

import com.airatchaplin.currencyrest.model.Currency;
import com.airatchaplin.currencyrest.service.ServiceCurrency;
import com.airatchaplin.currencyrest.service.ServiceFeignClientGif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiRestController {

    @Autowired
    ServiceCurrency serviceCurrent;

    @Autowired
    ServiceFeignClientGif serviceFeignClientGif;

    @Value("${symbols}")
    String symbol;

    @Value("${date}")
    String date;

    @Value("${app_id}")
    String app_id;

    @Value("${api_key}")
    String api_key;

    @GetMapping("/")
    public Object getResponseAtGif(){

        Currency currencyToday = serviceCurrent.getToday(app_id,symbol);
        Currency currencyAnyDay = serviceCurrent.getAnyDay(date,app_id, symbol);

        Map<String,Double> mapAnyDay = currencyAnyDay.getRates();
        Map<String,Double> mapToday = currencyToday.getRates();
        Object gif;
        if (mapToday.get(symbol)>mapAnyDay.get(symbol)){
            gif= serviceFeignClientGif.getGif(api_key,new AnnotationConfigApplicationContext().getEnvironment().getProperty("tag_rich"));
        }else {
            gif=serviceFeignClientGif.getGif(api_key,new AnnotationConfigApplicationContext().getEnvironment().getProperty("tag_broke"));
        }
        return gif;
    }

}
