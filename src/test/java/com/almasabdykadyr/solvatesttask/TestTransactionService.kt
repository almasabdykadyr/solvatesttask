package com.almasabdykadyr.solvatesttask

import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode
import com.almasabdykadyr.solvatesttask.data.enums.OperationType
import com.almasabdykadyr.solvatesttask.data.repository.ExpenseLimitRepository
import com.almasabdykadyr.solvatesttask.data.repository.TransactionRepository
import com.almasabdykadyr.solvatesttask.services.TransactionService
import com.almasabdykadyr.solvatesttask.data.dto.TransactionCreateRequestDto
import com.almasabdykadyr.solvatesttask.util.CurrencyExchangeHelper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.math.BigDecimal

class TestTransactionService {
    @Test
    @DisplayName("Test successful transaction")
    fun testTransactionServiceSuccessful() {
        val transactionRepository = Mockito.mock(TransactionRepository::class.java)
        val expenseLimitRepository = Mockito.mock(ExpenseLimitRepository::class.java)
        val helper = Mockito.mock(CurrencyExchangeHelper::class.java)

        val transactionService =
            TransactionService(transactionRepository, expenseLimitRepository, helper)

        val dto =
            TransactionCreateRequestDto(
                "000000",
                "000001",
                CurrencyCode.USD,
                OperationType.SERVICE,
                BigDecimal(500)
            )

//        val answer = transactionService.createTransaction(dto)
//
//        Assertions.assertEquals(answer.accountFromId, dto.accountFrom)
//        Assertions.assertEquals(answer.accountToId, dto.accountTo)
//        Assertions.assertEquals(answer.sum, dto.sum)
    }
}