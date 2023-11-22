package com.example.catatankeuangan.features

import androidx.lifecycle.ViewModel
import com.example.catatankeuangan.data.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// TransactionViewModel.kt
class TransactionViewModel : ViewModel() {

    private val _transactions = MutableStateFlow<List<Transaction>>(listOf())
    val transactions: StateFlow<List<Transaction>> get() = _transactions

    private val _totalBalance = MutableStateFlow(0.toLong())
    val totalBalance: StateFlow<Long> get() = _totalBalance

    fun addTransaction(transaction: Transaction) {
        _transactions.value = _transactions.value + transaction
        println("berhasil tambah")
        recalculateBalance()
        _transactions.value.map { v -> {
            println(v.description);
            println(v.id);
            println(v.amount);
        }
        }
    }

    fun editTransaction(updatedTransaction: Transaction) {
        _transactions.value = _transactions.value.map {
            if (it.id == updatedTransaction.id) updatedTransaction else it
        }
        recalculateBalance()
    }

    fun deleteTransaction(transactionId: String) {
        _transactions.value = _transactions.value.filter { it.id != transactionId }
        recalculateBalance()
    }

    fun getAllTransactions(): List<Transaction> {
        return _transactions.value;
    }

    private fun recalculateBalance() {
        _totalBalance.value = _transactions.value.sumOf { it.amount }
        println(_totalBalance.value )
    }
}
