package com.example.uaspemrogramanmobile // ganti sesuai nama package proyek Anda

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * UAS Pemrograman Mobile - Paket C - Soal 2
 * Perbaikan penerapan state hoisting.
 *
 * State "teks" dikelola oleh ParentScreen (di-hoist).
 * InputNama menjadi stateless: hanya menerima value dan callback.
 */

@Composable
fun ParentScreen() {
    // State dikelola di Parent
    var teks by remember { mutableStateOf("") }

    InputNama(
        value = teks,
        onValueChange = { teks = it }
    )
}

@Composable
fun InputNama(
    value: String,
    onValueChange: (String) -> Unit
) {
    // Stateless: tidak menyimpan state sendiri
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Nama") }
    )
}

// Aktifkan "Interactive Mode" pada panel preview, lalu ketik di kolom Nama
// untuk melihat state bekerja tanpa emulator/HP.
@Preview(name = "Soal 2 - State Hoisting (interaktif)", showBackground = true, device = Devices.PIXEL_7)
@Composable
fun PreviewParentScreen() {
    MaterialTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            ParentScreen()
        }
    }
}
