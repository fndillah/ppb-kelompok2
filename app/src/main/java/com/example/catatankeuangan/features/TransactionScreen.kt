package com.example.catatankeuangan.features

//import androidx.lifecycle.viewmodel.compose.viewModels
//import androidx.fragment.app.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catatankeuangan.data.Transaction
import com.example.catatankeuangan.ui.CourseSection
import com.example.catatankeuangan.ui.TransactionActions
import com.example.catatankeuangan.ui.suggestionSection
import java.util.UUID

@OptIn(ExperimentalFoundationApi::class)
@Composable
//@Preview
fun TransactionScreen() {

    val viewModel: TransactionViewModel = viewModel()

    // Membuat State untuk menyimpan deskripsi dan jumlah transaksi baru
    var description: String by rememberSaveable { mutableStateOf("") }
    var id: String by rememberSaveable { mutableStateOf("") }
    var amount: String by rememberSaveable { mutableStateOf("") }

    var is_edit: Boolean by rememberSaveable { mutableStateOf(false) }


    var refreshTrigger by remember { mutableStateOf(1) }

//    var dataList by remember { mutableStateOf(viewModel.transactions) }

    suggestionSection(viewModel.totalBalance.collectAsState().value)
    // Membuat Composable untuk menampilkan formulir input
    InputForm(
        description = description,
        onDescriptionChange = { description = it },
        amount = amount,
        onAmountChange = { amount = it },
        is_edit = is_edit
    ) {
        // Validasi dan tambahkan transaksi
        if (description.isNotEmpty() && amount.isNotEmpty() && is_edit) {
            val transaction = Transaction(id,description,amount.toLong())
            viewModel.editTransaction(transaction)
            println("$id edited")
            is_edit = !is_edit
            description = ""
            amount = ""
        } else if (description.isNotEmpty() && amount.isNotEmpty()) {
            val transaction = Transaction(UUID.randomUUID().toString(), description, amount.toLong())
            viewModel.addTransaction(transaction)

            println(transaction)
            println("ikz")
            refreshTrigger++
//            println(dataList)
//            dataList = viewModel.getAllTransactions()
            // Mengosongkan input setelah transaksi ditambahkan
                description = ""
                amount = ""
        } else {

        }
    }

    CourseSection(
                transcs = viewModel.transactions.collectAsState().value,
//                onDelete = viewModel.deleteTransaction(description)
                transactionActions = object : TransactionActions {
                    override fun onDelete(transactionId: String) {
                        viewModel.deleteTransaction(transactionId)
                    }
                    override fun onEdit(transaction: Transaction) {
                        description = transaction.description
                        amount = transaction.amount.toString()
                        id = transaction.id
                        is_edit = !is_edit
                    }
                }
            )


}