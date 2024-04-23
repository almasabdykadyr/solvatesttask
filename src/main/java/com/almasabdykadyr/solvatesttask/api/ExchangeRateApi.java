package com.almasabdykadyr.solvatesttask.api;

import com.almasabdykadyr.solvatesttask.api.dto.ExchangeRateRequestToApi;
import feign.Param;
import feign.RequestLine;

public interface ExchangeRateApi {

    @RequestLine("GET /latest.json?app_id={app_id}&base={base}&symbols={targets}")
    public ExchangeRateRequestToApi getExchangeRate(@Param("app_id") String appId, @Param("base") String baseCurrency, @Param("targets") String targetCurrencies);
}
