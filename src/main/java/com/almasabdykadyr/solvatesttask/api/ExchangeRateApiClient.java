package com.almasabdykadyr.solvatesttask.api;

import com.almasabdykadyr.solvatesttask.api.dto.ExchangeRateRequestToApi;
import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeRateApiClient {

    ExchangeRateApi exchangeRateApi = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(ExchangeRateApi.class, "https://openexchangerates.org/api/");

    public ExchangeRateRequestToApi getExchangeRate() {
        return exchangeRateApi.getExchangeRate(
                "a042faad89484a2ea9c8da0957ab645d", CurrencyCode.USD.toString(), CurrencyCode.KZT + "," + CurrencyCode.RUB);
    }
}
