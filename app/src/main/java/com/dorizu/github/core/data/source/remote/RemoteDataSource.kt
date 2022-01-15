package com.dorizu.github.core.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import com.dorizu.github.core.data.source.remote.network.ApiResponse
import com.dorizu.github.core.data.source.remote.network.ApiService
import com.dorizu.github.core.data.source.remote.response.DetailUserResponse
import com.dorizu.github.core.data.source.remote.response.RepositoryUserResponse
import com.dorizu.github.core.data.source.remote.response.UserGithubResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
){
    @SuppressLint("CheckResult")
    fun searchUser(key: String, limit: Int? = null, page: Int? = null): Flowable<ApiResponse<List<UserGithubResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<UserGithubResponse>>>()

        apiService.searchUser(key, limit, page)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({response ->
                val data = response.items
                resultData.onNext(if (!data.isNullOrEmpty()) ApiResponse.Success(data) else ApiResponse.Empty)
            },{ error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e(TAG, error.message.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    @SuppressLint("CheckResult")
    fun getUserDetail(username: String): Flowable<ApiResponse<DetailUserResponse>> {
        val resultData = PublishSubject.create<ApiResponse<DetailUserResponse>>()

        apiService.getDetailUser(username)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({response ->
                resultData.onNext(if (response != null) ApiResponse.Success(response) else ApiResponse.Empty)
            },{ error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e(TAG, error.message.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    @SuppressLint("CheckResult")
    fun getListReposUser(username: String): Flowable<ApiResponse<List<RepositoryUserResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<RepositoryUserResponse>>>()

        apiService.getListReposUser(username)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({response ->
                resultData.onNext(if (!response.isNullOrEmpty()) ApiResponse.Success(response) else ApiResponse.Empty)
            },{ error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e(TAG, error.message.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    companion object{
        const val TAG = "RemoteDataSource"
    }
}