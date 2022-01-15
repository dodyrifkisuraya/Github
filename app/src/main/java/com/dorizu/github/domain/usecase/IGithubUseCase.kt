package com.dorizu.github.domain.usecase

import com.dorizu.github.core.data.ResultState
import com.dorizu.github.domain.model.DetailUser
import com.dorizu.github.domain.model.RepositoryUser
import com.dorizu.github.domain.model.User
import io.reactivex.Flowable

interface IGithubUseCase {
    fun searchUser(key: String): Flowable<ResultState<List<User>>>
    fun getDetailUser(username: String): Flowable<ResultState<DetailUser>>
    fun getRepositoryUser(username: String): Flowable<ResultState<List<RepositoryUser>>>
}