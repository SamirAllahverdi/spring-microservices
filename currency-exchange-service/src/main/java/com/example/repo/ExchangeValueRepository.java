package com.example.repo;

import com.example.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {

    Optional<ExchangeValue> findByFromAndTo(String from, String to);
}
