package com.almasabdykadyr.solvatesttask.data.dto

import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode
import com.almasabdykadyr.solvatesttask.data.enums.OperationType
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Basic
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.TemporalType
import org.springframework.data.jpa.repository.Temporal
import java.math.BigDecimal
import java.time.ZonedDateTime

data class TransactionResponseDto(
    @JsonProperty("account_from") val accountFrom: String,
    @JsonProperty("account_to") val accountTo: String,
    @JsonProperty("currency_shortname") val transactionCurrencyCode: CurrencyCode,
    @JsonProperty("sum") val amount: BigDecimal,
    @JsonProperty("expense_category") val expenseCategory: OperationType,
    @JsonProperty("datetime")  val createdAt: ZonedDateTime,
    @JsonProperty("limit_sum") val limitAmount: BigDecimal,
    @JsonProperty("limit_datetime") val limitCreatedAt: ZonedDateTime,
    @JsonProperty("limit_currency_shortname") val limitCurrencyCode: CurrencyCode,
)