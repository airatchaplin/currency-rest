package com.airatchaplin.currencyrest.service;

import com.airatchaplin.currencyrest.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class ServiceGif {

    @Autowired
    ServiceFeignClientGif serviceFeignClientGif;

    public Gif getGif(String api_key, String tag) {
        LinkedHashMap mapGif = (LinkedHashMap) serviceFeignClientGif.getGif(api_key, tag);
        Gif gif = new Gif();
        gif.setId((String) ((LinkedHashMap) mapGif.get("data")).get("id"));
        gif.setUsername((String) ((LinkedHashMap) mapGif.get("data")).get("username"));
        gif.setTitle((String) ((LinkedHashMap) mapGif.get("data")).get("title"));
        gif.setUrl((String) ((LinkedHashMap) (((LinkedHashMap) (((LinkedHashMap) mapGif.get("data")).get("images"))).get("original"))).get("url"));
        return gif;
    }
}
