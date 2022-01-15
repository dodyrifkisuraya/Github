package com.dorizu.github.utils

import com.dorizu.github.core.data.source.remote.response.DetailUserResponse
import com.dorizu.github.core.data.source.remote.response.RepositoryUserResponse
import com.dorizu.github.core.data.source.remote.response.UserGithubResponse
import com.dorizu.github.domain.model.DetailUser
import com.dorizu.github.domain.model.RepositoryUser
import com.dorizu.github.domain.model.User

object DataMapper {
    fun mapListUserResponseToDomain(input: List<UserGithubResponse>) =
        input.map {
            User(
                login = it.login,
                avatarUrl = it.avatarUrl,
                id = it.id
            )
        }

    fun mapDetailUserResponseToDomain(input: DetailUserResponse) =
        DetailUser(
            username = input.login,
            name = input.name,
            avatarUrl = input.avatarUrl,
            bio = input.bio
        )

    fun mapListRepositoryResponseToDomain(input: List<RepositoryUserResponse>) =
        input.map {
            RepositoryUser(
                name = it.name,
                description = it.description,
                stargazersCount = it.stargazersCount,
                updatedAt = it.updatedAt
            )
        }
}