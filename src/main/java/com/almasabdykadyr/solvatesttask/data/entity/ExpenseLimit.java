package com.almasabdykadyr.solvatesttask.data.entity;

import com.almasabdykadyr.solvatesttask.data.enums.CurrencyCode;
import com.almasabdykadyr.solvatesttask.data.enums.OperationType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "expense_limit")
public class ExpenseLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String accountId;
    BigDecimal amount;

    @Enumerated(EnumType.STRING)
    CurrencyCode currency;

    @Enumerated(EnumType.STRING)
    OperationType operationType;

    ZonedDateTime createdAt;
}
