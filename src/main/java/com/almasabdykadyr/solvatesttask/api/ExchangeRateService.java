package com.almasabdykadyr.solvatesttask.api;

import com.almasabdykadyr.solvatesttask.api.dto.ExchangeRateRequestToApi;
import com.almasabdykadyr.solvatesttask.api.enitity.ExchangeRate;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExchangeRateService {

    ExchangeRateApiClient client;
    ExchangeRateRepository repository;

    public void saveExchangeRates() {

        ExchangeRateRequestToApi response = client.getExchangeRate();

        for (var i : response.getRates().entrySet()) {

            ExchangeRate entity = ExchangeRate.builder()
                    .timestamp(response.getTimestamp())
                    .baseCurrency(response.getBaseCurrency())
                    .targetCurrency(i.getKey())
                    .rate(i.getValue())
                    .build();

            repository.save(entity);
        }
    }


}
