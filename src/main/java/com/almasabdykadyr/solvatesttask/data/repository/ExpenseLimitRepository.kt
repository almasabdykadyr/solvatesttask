package com.almasabdykadyr.solvatesttask.data.repository

import com.almasabdykadyr.solvatesttask.data.entity.ExpenseLimit
import com.almasabdykadyr.solvatesttask.data.enums.OperationType
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseLimitRepository : JpaRepository<ExpenseLimit, Long> {


    fun findAllByAccountId(accountId: String): List<ExpenseLimit?>

    fun findByAccountIdAndOperationType(accountId: String, operationType: OperationType): ExpenseLimit?

    fun findFirstByAccountIdAndOperationTypeOrderByCreatedAtDesc(accountId: String, operationType: OperationType): ExpenseLimit?
}