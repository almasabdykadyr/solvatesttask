package com.almasabdykadyr.solvatesttask.controllers

import com.almasabdykadyr.solvatesttask.services.TransactionService
import com.almasabdykadyr.solvatesttask.data.dto.TransactionCreateRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController(
    private val transactionService: TransactionService
) {

    @PostMapping("/create")
    fun createTransaction(@RequestBody request: TransactionCreateRequestDto) {

        transactionService.createTransaction(request)
    }
}