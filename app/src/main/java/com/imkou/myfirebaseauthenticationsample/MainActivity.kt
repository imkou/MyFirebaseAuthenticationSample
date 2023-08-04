package com.imkou.myfirebaseauthenticationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.imkou.myfirebaseauthenticationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * 認証結果の通知Listener
     */
    private val authenticationListener = object: AuthenticationListener {
        // ログイン成功
        override fun onLoginSuccess() {
            Toast.makeText(applicationContext, "ログイン成功", Toast.LENGTH_SHORT).show()
        }
        // ログイン失敗
        override fun onLoginFailure(errorMessage: String) {
            Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
        }
        // 新規登録成功
        override fun onSignUpSuccess() {
            Toast.makeText(applicationContext, "新規登録成功", Toast.LENGTH_SHORT).show()
        }
        // 新規登録失敗
        override fun onSignUpFailure(errorMessage: String) {
            Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
        }
    }

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