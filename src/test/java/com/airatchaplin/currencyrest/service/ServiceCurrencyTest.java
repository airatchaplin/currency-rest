package com.airatchaplin.currencyrest.service;

import com.airatchaplin.currencyrest.model.Currency;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceCurrencyTest {

    @MockBean
    ServiceFeignClientCurrency serviceFeignClientCurrency;


    @Test
    void getToday() {
        Currency currency = serviceFeignClientCurrency.getToday("","","");
        Mockito.verify(serviceFeignClientCurrency,Mockito.times(1)).getToday("","","");
    }

    @Test
    void getAnyDay() {
        Currency currency = serviceFeignClientCurrency.getAnyDay("","","");
        Mockito.verify(serviceFeignClientCurrency,Mockito.times(1)).getAnyDay("","","");
    }

}