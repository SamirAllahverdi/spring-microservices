package com.example.controller;

import com.example.model.ExchangeValue;
import com.example.service.ExchangeValueService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class ExchangeValueController {

    private final Environment env;

    private final ExchangeValueService service;

    @GetMapping("/currency-exchange-service/from/{from}/to/{to}")
    public ExchangeValue get(@PathVariable String from, @PathVariable String to) {
        int port = Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port")));

        ExchangeValue exchangeValue = service.findByFromAndTo(from, to);
        exchangeValue.setPort(port);

        return exchangeValue;
    }
}
