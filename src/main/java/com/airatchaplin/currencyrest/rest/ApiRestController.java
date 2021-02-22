package com.airatchaplin.currencyrest.rest;

import com.airatchaplin.currencyrest.model.Currency;
import com.airatchaplin.currencyrest.model.Gif;
import com.airatchaplin.currencyrest.service.ServiceCurrency;
import com.airatchaplin.currencyrest.service.ServiceGif;
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
    ServiceGif serviceGif;

    @Value("${symbols}")
    String symbol;

    @Value("${date}")
    String date;

    @Value("${app_id}")
    String app_id;

    @Value("${api_key}")
    String api_key;

    @Value("${tag_rich}")
    String tag_rich;

    @Value("${tag_broke}")
    String tag_broke;

    @GetMapping("/")
    public Gif getResponseAtGif(Currency currencyToday,Currency currencyAnyDay) {

        if (currencyAnyDay.getRates() == null && currencyToday.getRates() == null) {
            currencyToday = serviceCurrent.getToday(app_id, symbol);
            currencyAnyDay = serviceCurrent.getAnyDay(date, app_id, symbol);
        }
        Map<String, Double> mapAnyDay = currencyAnyDay.getRates();
        Map<String, Double> mapToday = currencyToday.getRates();

        Gif gif;
        if (mapToday.get(symbol) > mapAnyDay.get(symbol)) {
            gif = serviceGif.getGif(api_key, tag_rich);
            gif.setTag(tag_rich);
        } else {
            gif = serviceGif.getGif(api_key, tag_broke);
            gif.setTag(tag_broke);

        }
        return gif;
    }

}
