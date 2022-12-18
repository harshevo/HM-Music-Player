package com.harshmishra.hmmusicplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harshmishra.hmmusicplayer.databinding.ActivityPlaylistActivtiyBinding

class playlist_activtiy : AppCompatActivity() {

    private lateinit var binding: ActivityPlaylistActivtiyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlaylistActivtiyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //        back button working
        binding.backBtn1.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}