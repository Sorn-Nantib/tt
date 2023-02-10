package com.example.retrofitmyself

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.retrofitmyself.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)

    private  lateinit var binding: ActivitySplashScreenBinding
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
     binding.splashScreen.alpha = 0f
        binding.splashScreen.animate().setDuration(1500).alpha(1f).withEndAction{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}