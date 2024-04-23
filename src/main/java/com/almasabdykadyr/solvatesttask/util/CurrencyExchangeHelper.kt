package com.almasabdykadyr.solvatesttask.util

import com.almasabdykadyr.solvatesttask.api.ExchangeRateRepository
import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class CurrencyExchangeHelper(
    private val exchangeRateRepository: ExchangeRateRepository
) {

    fun getExchangedCurrency(value: BigDecimal, currency: CurrencyCode): BigDecimal {

        if (currency == CurrencyCode.USD) {
            return value
        } else {
            val rate = exchangeRateRepository.findOneByTargetCurrency(currency.toString()).rate

            return value / rate
        }
    }
}