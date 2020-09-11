package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionBean {

    private Long id;

    private String from;

    private String to;

    private BigDecimal rate;

    private BigDecimal quantity;

    private BigDecimal totalCalculatedAmount;

    private int port;

    public CurrencyConversionBean(Long id, String from, String to, BigDecimal rate, BigDecimal quantity, BigDecimal totalCalculatedAmount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
}
