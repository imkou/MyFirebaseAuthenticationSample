package com.imkou.myfirebaseauthenticationsample

import com.google.firebase.auth.FirebaseAuth

/**
 * Firebase Authentication のUtilクラス
 */
class MyFirebaseAuthenticationUtil private constructor() {

    companion object {
        val instance: MyFirebaseAuthenticationUtil by lazy { MyFirebaseAuthenticationUtil() }
    }

    /**
     * Firebase Authenticationのシングルトン
     */
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    /**
     * 新規ユーザの登録
     * @param email E-mailアドレス
     * @param password パスワード
     */
    fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // signUp成功時の処理
                } else {
                    // signUp失敗時の処理
                }
            }
    }

    /**
     * Login
     * @param email E-mailアドレス
     * @param password パスワード
     */
    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Login成功時の処理
                } else {
                    // Login失敗時の処理
                }
            }
    }

    /**
     * ログアウト
     */
    fun logout() {
        firebaseAuth.signOut()
    }

    /**
     * ログイン状態を問い合わせ返却する
     * @return Boolean
     */
    fun loginStatus(): Boolean {
        return firebaseAuth.currentUser != null
    }

}
