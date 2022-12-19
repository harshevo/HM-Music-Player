package com.harshmishra.hmmusicplayer

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.harshmishra.hmmusicplayer.databinding.ActivityPlayerhmBinding

class Playerhm : AppCompatActivity() {
    companion object {
        lateinit var musicListPA : ArrayList<music>
        var songPosition : Int =0
        var mediaPlayer:MediaPlayer? =null
        var isPlaying : Boolean = false

    }
    private lateinit var binding: ActivityPlayerhmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlayerhmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        IntLayout()
        binding.playnpause.setOnClickListener{
            if(isPlaying) pauseMusic()
            else playMusic()
        }
    }
    //image for player activity :- playerhm

    private fun setLayout(){
        Glide.with(this)
            .load(musicListPA[songPosition].artUri)
            .apply(RequestOptions().placeholder(R.drawable.splah_screen).centerCrop())
            .into(binding.SongIMGPA)
        binding.songNamePA.text = musicListPA[songPosition].title
    }

    private fun createMediaPlayer(){
        try {
            if(mediaPlayer==null) mediaPlayer = MediaPlayer()
            mediaPlayer!!.reset()
            mediaPlayer!!.setDataSource(musicListPA[songPosition].path)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
            isPlaying = true
            binding.playnpause.setIconResource(R.drawable.pause_icon)
        }catch (e:java.lang.Exception){return}
    }

    private fun IntLayout(){
        songPosition = intent.getIntExtra("index",0)

        when(intent.getStringExtra("class")){
            "MusicAdapter" ->{
                musicListPA = ArrayList()
                musicListPA.addAll(MainActivity.MusicListMA)
                setLayout()
                createMediaPlayer()

            }
        }
        //        back button working
        binding.backBtn2.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        // audio file sharing
        binding.shareBtnPhm.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "audio/*"
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(musicListPA[songPosition].path))
            startActivity(Intent.createChooser(shareIntent, "share"))
        }
    }

    //function for play n pause
    private fun playMusic(){
        binding.playnpause.setIconResource(R.drawable.pause_icon)
        isPlaying=true
        mediaPlayer!!.start()
    }
    private fun pauseMusic(){
        binding.playnpause.setIconResource(R.drawable.play_icon)
        isPlaying=false
        mediaPlayer!!.pause()
    }
}