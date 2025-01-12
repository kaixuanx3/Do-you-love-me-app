package com.example.doyouloveme

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.doyouloveme.databinding.ActivityHomepageBinding
import kotlin.random.Random

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .asGif()
            .load(R.drawable.homepage_cat)
            .into(binding.gifHomepage)

        // Set up click listener for the "No" button
        binding.noButton.setOnClickListener {
            moveButtonRandomly(binding.noButton)
        }

        binding.yesButton.setOnClickListener {
            val intent = Intent(this, YesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun moveButtonRandomly(button: View) {
        // Get screen bounds
        val screenBounds = Rect()
        binding.rootFrameLayout.getGlobalVisibleRect(screenBounds)

        // Calculate random X and Y within screen bounds
        val buttonWidth = button.width
        val buttonHeight = button.height
        val maxX = screenBounds.width() - buttonWidth
        val maxY = screenBounds.height() - buttonHeight

        // Generate random positions
        val randomX = Random.nextInt(0, maxX)
        val randomY = Random.nextInt(0, maxY)

        // Debug log
        Log.d("RandomMove", "Moving to X: $randomX, Y: $randomY")

        // Move the button
        button.animate()
            .x(randomX.toFloat())
            .y(randomY.toFloat())
            .setDuration(300) // Animation duration
            .start()
    }
}
