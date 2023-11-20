package com.example.catatankeuangan.features

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.UUID

@Composable
@Preview
fun TransactionScreen() {
    // Mendapatkan instance ViewModel
    val viewModel:  TransactionViewModel = viewModel(
        viewModelStoreOwner = LocalViewModelStoreOwner.current!!,
        key = null, // You can provide a key if needed
        factory = null, // Use the default factory or provide a custom one if needed
//        extras = viewModelExtrasOf() // Use the default extras
    )

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
                val transaction = Transaction (UUID.randomUUID().toString(), description, amount.toInt())
                viewModel.addTransaction(transaction)

                println(transaction)
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
//    TransactionList(transactions = viewModel.transactions.collectAsState().value)
//    TotalBalance(totalBalance = viewModel.totalBalance.collectAsState().value)
}