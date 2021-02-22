package com.airatchaplin.currencyrest.model;

import lombok.Data;
import java.util.Map;

@Data
public class Currency {

    String base;
    Map<String,Double> rates;
    String date;
}
