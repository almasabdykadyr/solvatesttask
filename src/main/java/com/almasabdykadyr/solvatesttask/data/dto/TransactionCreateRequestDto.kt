package com.almasabdykadyr.solvatesttask.data.dto

import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode
import com.almasabdykadyr.solvatesttask.data.enums.OperationType
import java.math.BigDecimal
import java.time.ZonedDateTime

data class TransactionCreateRequestDto(
    val accountFrom: String,
    val accountTo: String,
    val currencyCode: CurrencyCode,
    val expenseCategory: OperationType,
    val sum: BigDecimal,
)
