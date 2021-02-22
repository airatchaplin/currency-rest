package com.airatchaplin.currencyrest.service;

import com.airatchaplin.currencyrest.model.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency-api",url = "${currency-api.ribbon.listOfServers}")
public interface ServiceFeignClientCurrency {

    @GetMapping("/historical/{date}.json")
    Currency getAnyDay(@PathVariable("date") String date, @RequestParam("app_id")String app_id,@RequestParam("symbols")String symbols);

    @GetMapping("/historical/{date}.json")
    Currency getToday(@PathVariable("date") String date, @RequestParam("app_id")String app_id,@RequestParam("symbols")String symbols);
}
