package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormPendaftaran(modifier: Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var stat by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val status = listOf("Janda", "Lajang", "Duda")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5E6F7)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Formulir Pendaftaran",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 20.sp
            )
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(text = "NAMA")
                    OutlinedTextField(
                        value = textNama,
                        onValueChange = { textNama = it },
                        singleLine = true,
                        label = { Text("Nama") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "JENIS KELAMIN")
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = textJK == item,
                                    onClick = { textJK = item }
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            Text(
                                text = item,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "STATUS")
                    status.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = textStatus == item,
                                    onClick = { textStatus = item }
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            )
                            Text(
                                text = item,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}