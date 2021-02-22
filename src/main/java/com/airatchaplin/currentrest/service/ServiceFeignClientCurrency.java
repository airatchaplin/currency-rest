package com.airatchaplin.currentrest.service;

import com.airatchaplin.currentrest.model.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "currency-api",url = "${currency-api.ribbon.listOfServers}")
public interface ServiceFeignClientCurrency {



    @GetMapping("/historical/{data}.json?app_id=d475716c83694807b148e1bc9c3e337c&symbols={currency}" )
    public Currency getYesterday(@PathVariable("data") String data, @PathVariable("currency") String currency);

    @GetMapping("/historical/{data}.json?app_id=d475716c83694807b148e1bc9c3e337c&symbols={currency}" )
    public Currency getToday(@PathVariable("data") String data,@PathVariable("currency") String currency);
}