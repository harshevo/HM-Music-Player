package com.harshmishra.hmmusicplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harshmishra.hmmusicplayer.databinding.ActivityFavBinding

class fav_activity : AppCompatActivity() {
    private lateinit var binding: ActivityFavBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityFavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //        back button working
        binding.backBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}