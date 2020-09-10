package com.example.service;


import com.example.exception.ExchangeValueNotFound;
import com.example.model.ExchangeValue;
import com.example.repo.ExchangeValueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ExchangeValueService {

    private final ExchangeValueRepository repo;


    public ExchangeValue findByFromAndTo(String from, String to) {
        return repo.findByFromAndTo(from, to).
                orElseThrow(() -> new ExchangeValueNotFound(String.format("From =  %s , To = %s", from, to)));
    }

}
