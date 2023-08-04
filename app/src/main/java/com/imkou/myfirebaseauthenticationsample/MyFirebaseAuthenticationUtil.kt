package com.imkou.myfirebaseauthenticationsample

import com.google.firebase.auth.FirebaseAuth

/**
 * Firebase Authentication のUtilクラス
 */
class MyFirebaseAuthenticationUtil private constructor() {

    private var listener: AuthenticationListener? = null

    companion object {
        val instance: MyFirebaseAuthenticationUtil by lazy { MyFirebaseAuthenticationUtil() }
    }

    /**
     * Listenerを登録する
     * @param listener 認証結果を返却するリスナー
     */
    fun setAuthenticationListener(listener: AuthenticationListener) {
        this.listener = listener
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
                    listener?.onSignUpSuccess()
                } else {
                    // signUp失敗時の処理
                    val exception = task.exception
                    val message = exception?.message.toString()
                    // errorメッセージを返却する
                    listener?.onSignUpFailure(message)
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
                    listener?.onLoginSuccess()
                } else {
                    // Login失敗時の処理
                    val exception = task.exception
                    val message = exception?.message.toString()
                    listener?.onLoginFailure(message)
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
