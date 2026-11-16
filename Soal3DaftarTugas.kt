package com.example.uaspemrogramanmobile // ganti sesuai nama package proyek Anda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * UAS Pemrograman Mobile - Paket C - Soal 3
 * Daftar tugas kuliah dengan LazyColumn dan Card.
 */

data class Tugas(val judul: String, val tanggal: String)

@Composable
fun DaftarTugas() {
    val daftar = listOf(
        Tugas("Tugas Pemrograman Mobile", "20 Nov 2026"),
        Tugas("Laporan Basis Data", "22 Nov 2026"),
        Tugas("Makalah Etika Profesi", "25 Nov 2026")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(daftar) { tugas ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = tugas.judul,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Dikumpulkan: ${tugas.tanggal}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Button(onClick = { /* aksi menuju detail */ }) {
                        Text("Detail")
                    }
                }
            }
        }
    }
}

@Preview(name = "Soal 3 - Daftar Tugas", showBackground = true, device = Devices.PIXEL_7)
@Composable
fun PreviewDaftarTugas() {
    MaterialTheme { DaftarTugas() }
}
