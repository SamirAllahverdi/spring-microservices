package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LimitConfiguration {
    private final int max;
    private final int min;
}
