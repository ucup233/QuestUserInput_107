package com.example.myapplication

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp



@Composable
fun FormDataDiri(modifier: Modifier){
    var txtNama by remember { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtJK by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender:List<String> = listOf("Laki-laki", "Perempuan")

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = txtNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),

            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                txtNama = it
            }
        )

        Row{
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = txtJK == item,
                    onClick = {txtJK = item}
                ), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = txtJK == item,
                        onClick = {
                            txtJK == item
                        }
                    )
                    Text(item)
                }
            }
        }

        OutlinedTextField(
            value = txtAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),

            label = { Text(text = "Alamat") },
            onValueChange = {
                txtAlamat = it
            }
        )

        HorizontalDivider(
            modifier = Modifier.padding(bottom = 30.dp, top = 30.dp),
            thickness = 1.dp,
            color = Color.DarkGray
        )

        Button(
            modifier = Modifier.fillMaxWidth(1f),
            enabled = txtAlamat.isNotEmpty(),
            onClick = {
                nama = txtNama
                jenis = txtJK
                alamat = txtAlamat
            }
        ) {
            Text(text = "Submit")
        }

        HorizontalDivider(
            modifier = Modifier.padding(bottom = 30.dp, top = 30.dp),
            thickness = 1.dp,
            color = Color.DarkGray
        )

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(height = 100.dp)
                .width(width = 300.dp)
        ) {

        }

    }
}