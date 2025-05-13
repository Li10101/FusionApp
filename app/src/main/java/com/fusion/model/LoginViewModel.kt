package com.fusion.model

import android.util.Log
import androidx.lifecycle.ViewModel
import com.fusion.data.LoginRequest
import com.fusion.net.NetworkHelper
import com.fusion.net.NetworkHelper.TAG
import com.fusion.net.RetrofitClient
import com.google.gson.Gson
import io.reactivex.rxjava3.disposables.CompositeDisposable

class LoginViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    fun login(username: String, password: String) {
        var loginRequest = LoginRequest(username,password)
        //var hashMap = mapOf<String,String>("username" to username,"password" to password)
//        hashMap["username"]  =  username
//        hashMap["password"]  = password
        var params = Gson().toJson(loginRequest)
        val disposable = NetworkHelper.execute(
            //observable = RetrofitClient.apiService.login(loginRequest),
            observable = RetrofitClient.apiService.login(username,password),
            onSuccess = { response ->
                // 处理登录成功
                Log.d(TAG,"onSuccess:::${response.toString()}")
//                saveToken(response.token)
//                navigateToHome()
            },
            onError = { error ->
                // 处理错误
                Log.d(TAG,"onError:::${error.message.toString()}")
                //showError(error.message)
            }
        )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear() // 防止内存泄漏
    }
}