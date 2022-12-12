package com.harshmishra.hmmusicplayer

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harshmishra.hmmusicplayer.databinding.ActivityPlayerhmBinding

class Playerhm : AppCompatActivity() {
    companion object {
        lateinit var musicListPA : ArrayList<music>
        var songPosition : Int =0
        var mediaPlayer:MediaPlayer? =null
    }
    private lateinit var binding: ActivityPlayerhmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlayerhmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        songPosition = intent.getIntExtra("index",0)

        when(intent.getStringExtra("class")){
            "MusicAdapter" ->{
                musicListPA = ArrayList()
                musicListPA.addAll(MainActivity.MusicListMA)
                if(mediaPlayer==null) mediaPlayer = MediaPlayer()
                mediaPlayer!!.reset()
                mediaPlayer!!.setDataSource(musicListPA[songPosition].path)
                mediaPlayer!!.prepare()
                mediaPlayer!!.start()


            }
        }
    }
}