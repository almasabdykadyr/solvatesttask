package com.almasabdykadyr.solvatesttask.services

import com.almasabdykadyr.solvatesttask.data.entity.ExpenseLimit
import com.almasabdykadyr.solvatesttask.data.entity.Transaction
import com.almasabdykadyr.solvatesttask.data.enums.OperationType
import com.almasabdykadyr.solvatesttask.data.repository.ExpenseLimitRepository
import com.almasabdykadyr.solvatesttask.data.repository.TransactionRepository
import com.almasabdykadyr.solvatesttask.data.dto.ExpiredTransactionsRequest
import com.almasabdykadyr.solvatesttask.data.dto.TransactionCreateRequestDto
import com.almasabdykadyr.solvatesttask.data.dto.TransactionResponseDto
import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode
import com.almasabdykadyr.solvatesttask.util.CurrencyExchangeHelper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.ZonedDateTime

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val expenseLimitRepository: ExpenseLimitRepository,
    private val helper: CurrencyExchangeHelper
) {

    @Transactional
    fun createTransaction(transactionDto: TransactionCreateRequestDto): Transaction {

        return transactionRepository.save(
            Transaction.builder()
                .accountFromId(transactionDto.accountFrom)
                .accountToId(transactionDto.accountTo)
                .amount(helper.getExchangedCurrency(transactionDto.sum, transactionDto.currencyCode))
                .currencyCode(CurrencyCode.USD)
                .operationType(transactionDto.expenseCategory)
                .createdAt(ZonedDateTime.now())
                .limitExceeded(
                    isLimitExceeded(
                        transactionDto.accountFrom, transactionDto.expenseCategory, transactionDto.sum
                    )
                )
                .build()
        )
    }

    @Transactional
    fun getBlockedTransactions(request: ExpiredTransactionsRequest): List<TransactionResponseDto> {

        val result = transactionRepository.findTransactionResponseDtoByCreatedAtAfterLimitDatetime(request.accountId)

        return result
    }

    private fun isLimitExceeded(id: String, type: OperationType, transactionSum: BigDecimal): Boolean {

        val lastLimit: ExpenseLimit =
            expenseLimitRepository.findFirstByAccountIdAndOperationTypeOrderByCreatedAtDesc(id, type) ?: return false

        val transactions = transactionRepository.findAllByAccountFromIdAndOperationTypeAndCreatedAtAfter(
            lastLimit.accountId, lastLimit.operationType, lastLimit.createdAt
        )

        var sum: BigDecimal = transactionSum
        for (transaction in transactions) {

            sum += transaction.amount
        }

        return sum > lastLimit.amount
    }
}