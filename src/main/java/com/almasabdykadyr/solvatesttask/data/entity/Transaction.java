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
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String accountFromId;
    String accountToId;

    @Enumerated(EnumType.STRING)
    CurrencyCode currencyCode;
    BigDecimal amount;

    @Enumerated(EnumType.STRING)
    OperationType operationType;

    ZonedDateTime createdAt;

    Boolean limitExceeded;
}