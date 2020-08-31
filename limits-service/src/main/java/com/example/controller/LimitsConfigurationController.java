package com.example.controller;

import com.example.config.Config;
import com.example.model.LimitConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LimitsConfigurationController {

    private final Config config;

    @GetMapping("/limits")
    public LimitConfiguration get() {
        return new LimitConfiguration(config.getMaximum(), config.getMinimum());
    }


}
