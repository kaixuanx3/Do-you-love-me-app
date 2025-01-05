package com.example.doyouloveme

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.doyouloveme.databinding.ActivityHomepageBinding
import kotlin.random.Random

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding
    private var screenWidth = 0
    private var screenHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .asGif()
            .load(R.drawable.homepage_cat)
            .into(binding.gifHomepage)

        binding.rootFrameLayout.post {
            screenWidth = binding.rootFrameLayout.width
            screenHeight = binding.rootFrameLayout.height
        }

        // Set up click listener for the "No" button
        binding.noButton.setOnClickListener {
            moveNoButtonRandomly()
        }

        binding.yesButton.setOnClickListener {
            val intent = Intent(this, YesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun moveNoButtonRandomly() {
        val noButtonLayout = binding.noButtonLayout

        // Calculate random X and Y positions within the screen bounds
        val randomX = Random.nextInt(0, screenWidth - noButtonLayout.width)
        val randomY = Random.nextInt(0, screenHeight - noButtonLayout.height)

        // Update the "No" button position using LayoutParams
        val layoutParams = noButtonLayout.layoutParams as FrameLayout.LayoutParams
        layoutParams.leftMargin = randomX
        layoutParams.topMargin = randomY
        noButtonLayout.layoutParams = layoutParams
    }
}
