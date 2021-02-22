package com.airatchaplin.currencyrest.rest;

import com.airatchaplin.currencyrest.model.Currency;
import com.airatchaplin.currencyrest.model.Gif;
import com.airatchaplin.currencyrest.service.ServiceCurrency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("classpath:currency.properties")
class ApiRestControllerTest {


    @Autowired
    ApiRestController apiRestController;

    @Autowired
    ServiceCurrency serviceCurrency;

    @Value("${symbols}")
    String symbol;

    @Value("${date}")
    String date;

    @Value("${app_id}")
    String app_id;

    @Value("${api_key}")
    String api_key;

    private static Map<String ,Double> rateMin;
    private static Map<String ,Double> rateMax;

    @BeforeEach
    void setUp() {
        rateMax = new HashMap<>();
        rateMin = new HashMap<>();
        rateMin.put("RUB", 1.0);
        rateMax.put("RUB", 2.0);
    }

    @Test
    void getResponseAtGifIfTodayMore() {
        Currency currencyToday = new Currency();
        currencyToday.setRates(rateMax);
        Currency currencyAnyDay = new Currency();
        currencyAnyDay.setRates(rateMin);
        Gif gif = apiRestController.getResponseAtGif(currencyToday,currencyAnyDay);
        Assertions.assertEquals(gif.getTag(),"rich");
    }

    @Test
    @DisplayName("getResponseAtGifIfTodayLess")
    void getResponseAtGifIfTodayLess() {
        Currency currencyToday = new Currency();
        currencyToday.setRates(rateMin);
        Currency currencyAnyDay = new Currency();
        currencyAnyDay.setRates(rateMax);
        Gif gif = apiRestController.getResponseAtGif(currencyToday,currencyAnyDay);
        Assertions.assertEquals(gif.getTag(),"broke");
    }

}