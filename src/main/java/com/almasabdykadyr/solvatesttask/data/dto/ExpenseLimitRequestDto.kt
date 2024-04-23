package com.almasabdykadyr.solvatesttask.data.dto

import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode
import com.almasabdykadyr.solvatesttask.data.enums.OperationType
import java.math.BigDecimal

data class ExpenseLimitRequestDto (
    var amount: BigDecimal = BigDecimal(1000),
    val currency: CurrencyCode,
    val type: OperationType,
    val accountId: String
)