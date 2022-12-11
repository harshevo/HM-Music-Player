package com.harshmishra.hmmusicplayer

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.harshmishra.hmmusicplayer.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //for nav drawer
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestRuntimePermission()
        setTheme(R.style.coolPinkNav)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //for nav drawer
        toggle = ActionBarDrawerToggle(this,binding.root,R.string.open,R.string.close)
        binding.root.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.shuffleBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,Playerhm::class.java)
            startActivity(intent)
        }
        binding.favBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,fav_activity::class.java)
            startActivity(intent)
        }


        binding.playlistBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,playlist_activtiy::class.java)
            startActivity(intent)
        }
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.navFeedback -> Toast.makeText(baseContext, "Feedback",Toast.LENGTH_SHORT).show()
                R.id.navSettings -> Toast.makeText(baseContext, "Settings",Toast.LENGTH_SHORT).show()
                R.id.navAbout -> Toast.makeText(baseContext, "About",Toast.LENGTH_SHORT).show()
                R.id.navExit -> exitProcess(1)
            }
            true
        }
    }
    //permission req
    private fun requestRuntimePermission(){
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),10)

        }
    }
//continue code for permissions
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==10){
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
            }
            else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),10)
            }
        }
    }
    //function must be override to support nav bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

}