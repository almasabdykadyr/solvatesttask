package com.almasabdykadyr.solvatesttask.controllers

import com.almasabdykadyr.solvatesttask.data.entity.Transaction
import com.almasabdykadyr.solvatesttask.services.ExpenseLimitService
import com.almasabdykadyr.solvatesttask.services.TransactionService
import com.almasabdykadyr.solvatesttask.data.dto.ExpenseLimitRequestDto
import com.almasabdykadyr.solvatesttask.data.dto.ExpiredTransactionsRequest
import com.almasabdykadyr.solvatesttask.data.dto.TransactionResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/")
class ClientController(
    private val expenseLimitService: ExpenseLimitService,
    private val transactionService: TransactionService,
) {

    @GetMapping("/exceeded-transactions")
    fun exceededTransactions(@RequestBody request: ExpiredTransactionsRequest): List<TransactionResponseDto> {

        return transactionService.getBlockedTransactions(request)
    }

    @PostMapping("/add-expense-limit")
    fun addExpenseLimit(@RequestBody request: ExpenseLimitRequestDto): ResponseEntity<String>  {

        expenseLimitService.createExpenseLimit(request)

        return ResponseEntity.ok().body("Limit created successfully")
    }
}