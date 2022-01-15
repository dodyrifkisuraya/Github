package com.dorizu.github.core.data.repository

import com.dorizu.github.core.data.MapApiResponseToResultState
import com.dorizu.github.core.data.ResultState
import com.dorizu.github.core.data.source.remote.RemoteDataSource
import com.dorizu.github.core.data.source.remote.network.ApiResponse
import com.dorizu.github.core.data.source.remote.response.DetailUserResponse
import com.dorizu.github.core.data.source.remote.response.RepositoryUserResponse
import com.dorizu.github.core.data.source.remote.response.UserGithubResponse
import com.dorizu.github.domain.model.DetailUser
import com.dorizu.github.domain.model.RepositoryUser
import com.dorizu.github.domain.model.User
import com.dorizu.github.domain.repository.IGithubRepository
import com.dorizu.github.utils.DataMapper
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): IGithubRepository {
    override fun searchUser(key: String): Flowable<ResultState<List<User>>> =
        object : MapApiResponseToResultState<List<User>, List<UserGithubResponse>>(){
            override fun createCall(): Flowable<ApiResponse<List<UserGithubResponse>>>
                = remoteDataSource.searchUser(key)

            override fun mapResponseToDomain(data: List<UserGithubResponse>): List<User>
                = DataMapper.mapListUserResponseToDomain(data)
        }.asFlowable()

    override fun getDetailUser(username: String): Flowable<ResultState<DetailUser>> =
        object : MapApiResponseToResultState<DetailUser, DetailUserResponse>(){
            override fun createCall(): Flowable<ApiResponse<DetailUserResponse>> {
                return remoteDataSource.getUserDetail(username)
            }

            override fun mapResponseToDomain(data: DetailUserResponse): DetailUser {
                return DataMapper.mapDetailUserResponseToDomain(data)
            }

        }.asFlowable()

    override fun getRepositoryUser(username: String): Flowable<ResultState<List<RepositoryUser>>> =
        object : MapApiResponseToResultState<List<RepositoryUser>, List<RepositoryUserResponse>>(){
            override fun createCall(): Flowable<ApiResponse<List<RepositoryUserResponse>>> {
                return remoteDataSource.getListReposUser(username)
            }

            override fun mapResponseToDomain(data: List<RepositoryUserResponse>): List<RepositoryUser> {
                return DataMapper.mapListRepositoryResponseToDomain(data)
            }

        }.asFlowable()

}