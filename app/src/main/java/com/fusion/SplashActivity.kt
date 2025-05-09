package com.fusion

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fusion.databinding.ActivitySplashBinding
import com.fusion.model.LoginViewModel
import com.fusion.net.RetrofitClient

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    var  loginView :LoginViewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //https://blog.csdn.net/guolin_blog/article/details/141500877
        enableEdgeToEdge()

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnLogin.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                var username = binding.etUsername.text.toString()
                var password = binding.etPassword.text.toString()
                loginView.login(username,password)
            }

        })


    }
}