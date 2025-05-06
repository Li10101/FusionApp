package com.fusion.net

import android.util.Log
import android.widget.Toast
import com.fusion.data.BaseResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object NetworkHelper {

    val TAG = "NetworkHelper"
    // 统一处理网络请求
    fun <T> execute(
        observable: Observable<BaseResponse<T>>,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit = { it.printStackTrace() },
        onComplete: () -> Unit = {}
    ): Disposable {
        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    when (response.code) {
                        200 -> onSuccess(response.data)
                        else -> handleApiError(response.code, response.message)
                    }
                },
                { error ->
                    handleNetworkError(error)
                    onError(error)
                },
                { onComplete() }
            )
    }

    private fun handleApiError(code: Int, message: String) {
        // 根据错误码处理特定逻辑
    }

    private fun handleNetworkError(error: Throwable) {
        when (error) {
            is SocketTimeoutException -> showToast("请求超时")
            is ConnectException -> showToast("网络连接失败")
            is UnknownHostException -> showToast("无法解析主机")
            else -> showToast("未知错误：${error.message}")
        }
    }

    private fun showToast(message: String){
        Log.d(TAG,message)
    }
}