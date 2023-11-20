package com.example.catatankeuangan.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.catatankeuangan.features.Text as FeaturesText
import org.w3c.dom.Text as Text1

// InputForm.kt

interface Text {
    fun printText()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputForm(
    description: String,
    onDescriptionChange: (String) -> Unit,
    amount: String,
    onAmountChange: (String) -> Unit,
    onAddTransaction: () -> Unit
) {
    // Menerapkan UI untuk formulir input di sini
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Input deskripsi
        OutlinedTextField (
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { FeaturesText ("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Input jumlah
        OutlinedTextField(
            value = amount,
            onValueChange = { onAmountChange(it) },
            label = { Text1("Amount") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Tombol tambah transaksi
        Button(
            onClick = { onAddTransaction() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text1("Add Transaction")
        }
    }
}
