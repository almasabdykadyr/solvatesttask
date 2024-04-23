package com.almasabdykadyr.solvatesttask.api;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExchangeRateScheduler {

    ExchangeRateService exchangeRateService;

    @PostConstruct
    @Scheduled(cron = "0 0 9 * * *")
    public void schedule() {

        exchangeRateService.saveExchangeRates();
    }
}
