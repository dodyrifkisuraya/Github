package com.dorizu.github.di

import com.dorizu.github.domain.usecase.GithubUseCase
import com.dorizu.github.domain.usecase.IGithubUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideGithubRepositoryUseCase(githubUseCase: GithubUseCase): IGithubUseCase
}