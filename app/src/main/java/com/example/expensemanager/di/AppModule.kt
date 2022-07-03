package com.example.expensemanager.di

import com.example.expensemanager.common.data.FirebaseService
import com.example.expensemanager.auth.data.remote.AuthRemoteApi
import com.example.expensemanager.auth.data.repository.IAuthRepositoryImpl
import com.example.expensemanager.auth.domain.repository.IAuthRepository
import com.example.expensemanager.auth.domain.use_cases.SignInUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseService(): FirebaseService = FirebaseService()
}