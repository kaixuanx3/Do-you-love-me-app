package com.example.doyouloveme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doyouloveme.databinding.ActivityYesBinding
import com.bumptech.glide.Glide

class YesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityYesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .asGif()
            .load(R.drawable.happycat)
            .into(binding.gifYes)

        binding.backIcon.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}