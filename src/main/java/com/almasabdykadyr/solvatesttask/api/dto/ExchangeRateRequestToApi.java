package com.almasabdykadyr.solvatesttask.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties
public class ExchangeRateRequestToApi {

    @JsonProperty("timestamp") String timestamp;
    @JsonProperty("base") String baseCurrency;
    @JsonProperty("rates") Map<String, BigDecimal> rates;
}
