package com.example.doyouloveme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}