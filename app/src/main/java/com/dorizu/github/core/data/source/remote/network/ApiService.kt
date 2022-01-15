package com.dorizu.github.core.data.source.remote.network

import com.dorizu.github.core.data.source.remote.response.DetailUserResponse
import com.dorizu.github.core.data.source.remote.response.RepositoryUserResponse
import com.dorizu.github.core.data.source.remote.response.SearchUserResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    fun searchUser(
        @Query("q") key: String,
        @Query("per_page") limit: Int? = null,
        @Query("page") page: Int? = null
    )
            : Flowable<SearchUserResponse>

    @GET("users/{username}")
    fun getDetailUser(@Path("username") username: String)
            : Flowable<DetailUserResponse?>

    @GET("users/{username}/repos")
    fun getListReposUser(@Path("username") username: String)
            : Flowable<List<RepositoryUserResponse>>
}