package com.example.expensemanager.auth.di

import com.example.expensemanager.auth.data.remote.AuthRemoteApi
import com.example.expensemanager.auth.data.repository.IAuthRepositoryImpl
import com.example.expensemanager.auth.domain.repository.IAuthRepository
import com.example.expensemanager.auth.domain.use_cases.AuthUseCases
import com.example.expensemanager.auth.domain.use_cases.RegisterUserUseCase
import com.example.expensemanager.auth.domain.use_cases.SignInUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object AuthDI {

    @Provides
    fun provideAuthRemoteApi(): AuthRemoteApi =
        AuthRemoteApi()

    @Provides
    fun provideAuthRepository(authRemoteApi: AuthRemoteApi): IAuthRepository =
        IAuthRepositoryImpl(authRemoteApi) as IAuthRepository

    @Provides
    fun provideAuthUseCases(IAuthRepository: IAuthRepository): AuthUseCases =
        AuthUseCases(
            ucRegisterUserUseCase = RegisterUserUseCase(IAuthRepository),
            ucSignInUserUseCase = SignInUserUseCase(IAuthRepository)
        )
}