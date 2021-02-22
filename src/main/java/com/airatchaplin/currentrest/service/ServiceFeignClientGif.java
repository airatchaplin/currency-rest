package com.airatchaplin.currentrest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@FeignClient(name = "giphy-api",url = "${giphy-api.ribbon.listOfServers}")
public interface ServiceFeignClientGif {


    @GetMapping("/random?api_key=UTmTgZMAXbT330ZhvwLrTkq1ww1Huk53&tag=rich")
    public Map<String, Object> getGifRich();

    @GetMapping("/random?api_key=UTmTgZMAXbT330ZhvwLrTkq1ww1Huk53&tag=broke")
    public Map<String, Object> getGifBroke();
}
