package com.example.tugasuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Agar layout tidak tertutup status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Hubungkan komponen dari XML dengan Kotlin
        val editFirstName = findViewById<EditText>(R.id.editFirstName)
        val editLastName = findViewById<EditText>(R.id.editLastName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // 🔹 Saat tombol Kirim ditekan
        btnSubmit.setOnClickListener {
            val firstName = editFirstName.text.toString().trim()
            val lastName = editLastName.text.toString().trim()

            // Cek apakah dua-duanya diisi
            if (firstName.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(this, "Isi nama depan dan nama belakang dulu!", Toast.LENGTH_SHORT).show()
            } else {
                val fullName = "$firstName $lastName"
                Toast.makeText(this, "Halo, $fullName!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
