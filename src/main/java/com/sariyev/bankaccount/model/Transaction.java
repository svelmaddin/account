package com.sariyev.bankaccount.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private BigDecimal amount;
    private TransactionType transactionType = TransactionType.INITIAL;
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction() {
    }

    public Transaction(BigDecimal amount,
                       TransactionType transactionType,
                       LocalDateTime transactionDate,
                       Account account) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.account = account;
    }

    public Transaction(String id, BigDecimal amount,
                       TransactionType transactionType,
                       LocalDateTime transactionDate,
                       Account account) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.account = account;
    }
    public Transaction(BigDecimal amount ,
                       Account account){
        this.amount = amount;
        this.transactionType = TransactionType.INITIAL;
        this.transactionDate = LocalDateTime.now();
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && transactionType == that.transactionType && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, transactionType, transactionDate);
    }
}

