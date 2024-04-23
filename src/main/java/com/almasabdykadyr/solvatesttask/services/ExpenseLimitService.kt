package com.almasabdykadyr.solvatesttask.services

import com.almasabdykadyr.solvatesttask.data.dto.ExpenseLimitRequestDto
import com.almasabdykadyr.solvatesttask.data.entity.ExpenseLimit
import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode
import com.almasabdykadyr.solvatesttask.data.enums.OperationType
import com.almasabdykadyr.solvatesttask.data.repository.ExpenseLimitRepository
import com.almasabdykadyr.solvatesttask.util.CurrencyExchangeHelper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

@Service
class ExpenseLimitService(
    private val expenseLimitRepository: ExpenseLimitRepository,
    private val helper: CurrencyExchangeHelper
) {

    @Transactional(readOnly = true)
    fun getLimitsById(id: String): List<ExpenseLimit?> {

        return expenseLimitRepository.findAllByAccountId(id)
    }

    @Transactional
    fun createExpenseLimit(request: ExpenseLimitRequestDto) {

        expenseLimitRepository.save(
            ExpenseLimit
                .builder()
                .accountId(request.accountId)
                .amount(helper.getExchangedCurrency(request.amount, request.currency))
                .currency(CurrencyCode.USD)
                .operationType(request.type)
                .createdAt(ZonedDateTime.now())
                .build()
        )
    }

    @Transactional
    fun getLimitByIdAndType(id: String, type: OperationType): ExpenseLimit? {

        return expenseLimitRepository.findByAccountIdAndOperationType(id, type)
    }
}
