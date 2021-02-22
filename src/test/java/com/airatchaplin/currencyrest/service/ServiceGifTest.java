package com.airatchaplin.currencyrest.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceGifTest {

    @MockBean
    ServiceFeignClientGif serviceFeignClientGif;

    @Test
    void getGif() {
        Map<String,Object> map = serviceFeignClientGif.getGif("","");
        Mockito.verify(serviceFeignClientGif,Mockito.times(1)).getGif("","");

    }
}