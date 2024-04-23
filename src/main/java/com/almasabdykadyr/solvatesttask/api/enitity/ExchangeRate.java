package com.almasabdykadyr.solvatesttask.api.enitity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "currency", timeToLive = 86400)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExchangeRate {

    String timestamp;
    String baseCurrency;
    @Id
    String targetCurrency;
    BigDecimal rate;
}
