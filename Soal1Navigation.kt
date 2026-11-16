package com.example.uaspemrogramanmobile // ganti sesuai nama package proyek Anda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * UAS Pemrograman Mobile - Paket C - Soal 1
 * Analisis alur Navigation Compose.
 */

// ---------------------------------------------------------------
// Kode dari soal (tidak diubah)
// ---------------------------------------------------------------
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // (a) startDestination = "home" -> halaman pertama yang dibuka
    // (e) NavHost = container graf navigasi yang menampilkan route aktif
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onDetail = {
                    // (b) route yang dipanggil saat tombol detail ditekan
                    navController.navigate("detail/42")
                }
            )
        }
        composable("detail/{id}") { entry ->
            // (c) id diambil dari argument route "detail/{id}"
            // (d) jika id tidak ditemukan (null), dipakai nilai pengganti "-"
            val id = entry.arguments?.getString("id") ?: "-"
            DetailScreen(id = id)
        }
    }
}

// ---------------------------------------------------------------
// Layar pendukung (dibuat sederhana agar program bisa dijalankan)
// ---------------------------------------------------------------
@Composable
fun HomeScreen(onDetail: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Halaman Home",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onDetail) {
            Text("Lihat Detail")
        }
    }
}

@Composable
fun DetailScreen(id: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Halaman Detail",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "ID yang diterima: $id",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

// ---------------------------------------------------------------
// Preview (untuk melihat tampilan tanpa menjalankan emulator)
// ---------------------------------------------------------------
@Preview(name = "Soal 1 - Home", showBackground = true, device = Devices.PIXEL_7)
@Composable
fun PreviewHomeScreen() {
    MaterialTheme { HomeScreen(onDetail = {}) }
}

@Preview(name = "Soal 1 - Detail", showBackground = true, device = Devices.PIXEL_7)
@Composable
fun PreviewDetailScreen() {
    MaterialTheme { DetailScreen(id = "42") }
}

// Preview seluruh alur navigasi. Aktifkan "Interactive Mode" pada panel preview,
// lalu tekan tombol "Lihat Detail" untuk berpindah halaman tanpa emulator/HP.
@Preview(name = "Soal 1 - Alur Navigasi (interaktif)", showBackground = true, device = Devices.PIXEL_7)
@Composable
fun PreviewAppNavigation() {
    MaterialTheme { AppNavigation() }
}
