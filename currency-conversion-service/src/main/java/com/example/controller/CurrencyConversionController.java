package com.example.controller;


import com.example.model.CurrencyConversionBean;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class CurrencyConversionController {
    private final Environment env;


    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean get(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(1L, from, to, BigDecimal.valueOf(1.7), quantity, quantity.multiply(BigDecimal.valueOf(1.7)));
        currencyConversionBean.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port"))));
        return currencyConversionBean;
    }
}
