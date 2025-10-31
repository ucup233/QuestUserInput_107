package com.example.myapplication.ui.theme

import android.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

fun FormDataDiri(modifier: Modifier){
    var txtNama by remember { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtJK by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender:List<String> = listOf("Laki-laki", "Perempuan")
}