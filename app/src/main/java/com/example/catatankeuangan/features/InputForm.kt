package com.example.catatankeuangan.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.catatankeuangan.ui.theme.DarkerButtonGreen
import com.example.catatankeuangan.ui.theme.TextWhite

// InputForm.kt

//interface Text {
//    fun printText()
//}


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
            label = {
                Text("Description", color = TextWhite)
                    },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
//                unfocusedBorderColor = Color.White,
                textColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Input jumlah
        OutlinedTextField(
            value = amount,
            onValueChange = { onAmountChange(it) },
            label = {
                Text("Amount", color = TextWhite)
                    },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
//                unfocusedBorderColor = Color.White,
                textColor = Color.White
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
//                .background()
        )

        // Tombol tambah transaksi
        Button(
            onClick = { onAddTransaction() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(DarkerButtonGreen)
        ) {
            Text("Add Transaction")
        }
    }
}
