package com.almasabdykadyr.solvatesttask.services

import com.almasabdykadyr.solvatesttask.data.entity.Account
import com.almasabdykadyr.solvatesttask.data.repository.AccountRepository

class AccountService(
    private val accountRepository: AccountRepository
) {

    fun createAccount(account: Account) {

        accountRepository.save(account)
    }
}
