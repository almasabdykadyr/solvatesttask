package com.almasabdykadyr.solvatesttask.data.repository;

import com.almasabdykadyr.solvatesttask.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {}
