package com.dorizu.github.domain.usecase

import com.dorizu.github.domain.repository.IGithubRepository
import javax.inject.Inject

class GithubUseCase @Inject constructor(
    private val githubRepository: IGithubRepository
): IGithubUseCase {
    override fun searchUser(key: String) = githubRepository.searchUser(key)

    override fun getDetailUser(username: String) = githubRepository.getDetailUser(username)

    override fun getRepositoryUser(username: String) = githubRepository.getRepositoryUser(username)
}