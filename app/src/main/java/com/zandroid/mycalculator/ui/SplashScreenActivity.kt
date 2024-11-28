package com.zandroid.mycalculator.ui

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.lifecycle.lifecycleScope
import coil.load
import com.zandroid.mycalculator.BuildConfig
import com.zandroid.mycalculator.R
import com.zandroid.mycalculator.databinding.ActivitySplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")

class SplashScreenActivity : AppCompatActivity() {

    //Binding
    private var _binding: ActivitySplashScreenBinding?=null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            imgSplash.load(R.drawable.calculator)
            //Animation
            initAnimation()
          /* ObjectAnimator.ofFloat(imgSplash,"translationX",-300f,0f).apply {
                duration=1000
                start()
            }*/

            lifecycleScope.launch {
                delay(3000)
                val intent= Intent(this@SplashScreenActivity,CalculatorActivity::class.java)
                startActivity(intent)
                finish()
            }


            txtVersion.text="version ${BuildConfig.VERSION_NAME}"
        }
    }

    private fun initAnimation(){
        val animation=ScaleAnimation(1f,1.25f,1f,1.25f,
            Animation.RELATIVE_TO_SELF,0.5f,
            Animation.RELATIVE_TO_SELF,0.5f)
        animation.duration=3000
        binding.imgSplash.startAnimation(animation)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}