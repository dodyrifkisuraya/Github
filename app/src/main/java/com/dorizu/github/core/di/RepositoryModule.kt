package com.dorizu.github.core.di

import com.dorizu.github.core.data.repository.GithubRepository
import com.dorizu.github.domain.repository.IGithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideGithubRepository(githubRepository: GithubRepository): IGithubRepository
}