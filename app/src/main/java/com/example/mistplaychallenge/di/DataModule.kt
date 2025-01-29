package com.example.mistplaychallenge.di

import com.example.mistplaychallenge.data.repositories.ImplPostsRepository
import com.example.mistplaychallenge.data.repositories.ImplUsersRepository
import com.example.mistplaychallenge.domain.repositories.PostsRepository
import com.example.mistplaychallenge.domain.repositories.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindPostsRepository(implPostsRepository: ImplPostsRepository): PostsRepository

    @Binds
    abstract fun bindUsersRepository(implUsersRepository: ImplUsersRepository): UsersRepository

}