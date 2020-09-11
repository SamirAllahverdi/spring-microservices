package com.example.controller;


import com.example.model.CurrencyConversionBean;
import com.example.proxy.CurrencyExchangeServiceProxy;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@AllArgsConstructor
@Log4j2
public class CurrencyConversionController {

    private final Environment env;

    private final RestTemplate restTemplate;

    private final CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean get(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariables = fillMap(from, to);

        ResponseEntity<CurrencyConversionBean> responseEntity = restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBean.class, uriVariables);
        CurrencyConversionBean response = responseEntity.getBody();

        log.info("Response Rest " + response);

        return new CurrencyConversionBean(response.getId(), from, to, response.getRate(), quantity, quantity.multiply(response.getRate()), response.getPort());
    }


    @GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean getFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = proxy.get(from,to);

        log.info("Response Feign " + response);

        return new CurrencyConversionBean(response.getId(), from, to, response.getRate(), quantity, quantity.multiply(response.getRate()), response.getPort());
    }

    private Map<String, String> fillMap(String from, String to) {

        HashMap<String, String> map = new HashMap<>();

        map.put("from", from);
        map.put("to", to);

        return map;
    }
}
