package com.imkou.myfirebaseauthenticationsample

/**
 * 認証結果を返却する自作リスナー
 */
interface AuthenticationListener {
    /**
     * ログイン成功
     */
    fun onLoginSuccess()

    /**
     * ログイン失敗
     * @param errorMessage エラーメッセージ
     */
    fun onLoginFailure(errorMessage: String)

    /**
     * 新規登録成功
     */
    fun onSignUpSuccess()

    /**
     * 新規登録失敗
     * @param errorMessage エラーメッセージ
     */
    fun onSignUpFailure(errorMessage: String)
}
