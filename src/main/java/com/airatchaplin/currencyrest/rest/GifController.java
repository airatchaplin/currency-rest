package com.airatchaplin.currencyrest.rest;

import com.airatchaplin.currencyrest.model.Currency;
import com.airatchaplin.currencyrest.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GifController {

    @Autowired
    ApiRestController apiRestController;

    @GetMapping("/gif")
    public String getGif(Model model){
        Gif gif = apiRestController.getResponseAtGif(new Currency(),new Currency());
        model.addAttribute("gif",gif);
        return "gif";
    }




}
