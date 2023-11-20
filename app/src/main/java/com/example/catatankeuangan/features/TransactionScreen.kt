package com.example.catatankeuangan.features

import android.view.SurfaceControl.Transaction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.UUID

@Composable
fun TransactionScreen() {
    // Mendapatkan instance ViewModel
    val viewModel:  TransactionViewModel

    // Membuat State untuk menyimpan deskripsi dan jumlah transaksi baru
    var description: String by rememberSaveable { mutableStateOf("") }
    var amount: String by rememberSaveable { mutableStateOf("") }

    // Membuat Composable untuk menampilkan formulir input
    InputForm(
        description = description,
        onDescriptionChange = { description = it },
        amount = amount,
        onAmountChange = { amount = it },
        onAddTransaction = {
            // Validasi dan tambahkan transaksi
            if (description.isNotEmpty() && amount.isNotEmpty()) {
                Transaction (UUID.randomUUID().toString(), description, amount.toDouble())
                viewModel.addTransaction(transaction)
                // Mengosongkan input setelah transaksi ditambahkan
                description = ""
                amount = ""
            } else {
                // Menampilkan pesan kesalahan jika input tidak valid
                // (Anda dapat menambahkan logika lain sesuai kebutuhan)
                // Contoh: showSnackbar("Description and amount are required")
            }
        }
    )

    // Menampilkan daftar transaksi dan total saldo
    TransactionList(transactions = viewModel.transactions.collectAsState().value)
    TotalBalance(totalBalance = viewModel.totalBalance.collectAsState().value)
}