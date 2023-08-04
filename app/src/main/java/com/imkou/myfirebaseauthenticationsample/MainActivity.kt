package com.imkou.myfirebaseauthenticationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imkou.myfirebaseauthenticationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {

        }
        binding.btnLogin.setOnClickListener {

        }
        binding.btnLogout.setOnClickListener {

        }
    }

    /**
     * EditTextに入力された値を取得する
     * @return email password
     */
    private fun getAuthenticationInfo(): Pair<String?, String?> {
        // EditTextに入力されていないときはnullを返却する
        val email = binding.etEmail.text.toString().takeIf { it.isNotEmpty() }
        val password = binding.etPassword.text.toString().takeIf { it.isNotEmpty() }

        return Pair(email,password)
    }
}