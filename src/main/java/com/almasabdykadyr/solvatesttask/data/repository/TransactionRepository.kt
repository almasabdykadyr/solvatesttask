package com.almasabdykadyr.solvatesttask.data.repository

import com.almasabdykadyr.solvatesttask.data.dto.TransactionResponseDto
import com.almasabdykadyr.solvatesttask.data.entity.Transaction
import com.almasabdykadyr.solvatesttask.data.enums.OperationType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.query.Param
import java.time.ZonedDateTime


@EnableJpaRepositories
interface TransactionRepository: JpaRepository<Transaction, Long> {

    @Query("SELECT new com.almasabdykadyr.solvatesttask.data.dto.TransactionResponseDto(t.accountFromId, t.accountToId, t.currencyCode, t.amount, t.operationType, t.createdAt, l.amount, l.createdAt, l.currency) FROM Transaction t JOIN ExpenseLimit l ON l.accountId = t.accountFromId WHERE t.accountFromId = :id AND t.operationType = l.operationType AND t.limitExceeded = TRUE AND t.createdAt >= l.createdAt ORDER BY t.createdAt DESC")
    fun findTransactionResponseDtoByCreatedAtAfterLimitDatetime(
        @Param("id") id: String
    ): List<TransactionResponseDto>

    fun findAllByAccountFromIdAndOperationTypeAndCreatedAtAfter(accountId: String, operationType: OperationType, createdAt: ZonedDateTime): List<Transaction>
}
