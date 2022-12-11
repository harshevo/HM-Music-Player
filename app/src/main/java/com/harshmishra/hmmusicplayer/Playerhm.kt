package com.harshmishra.hmmusicplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harshmishra.hmmusicplayer.databinding.ActivityPlayerhmBinding

class Playerhm : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerhmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlayerhmBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}