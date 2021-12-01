package com.example.expensemanager.di

import com.example.expensemanager.common.data.FirebaseService
import com.example.expensemanager.feature_login.data.data_source.LoginFirebaseService
import com.example.expensemanager.feature_login.data.repository.LoginRepositoryImpl
import com.example.expensemanager.feature_login.domain.repository.LoginRepository
import com.example.expensemanager.feature_login.domain.use_cases.SignInUserUseCase
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

    @Provides
    @Singleton
    fun provideLoginFirebaseService(): LoginFirebaseService = LoginFirebaseService()

    @Provides
    @Singleton
    fun provideLoginRepository(loginFirebaseService: LoginFirebaseService): LoginRepository =
        LoginRepositoryImpl(loginFirebaseService)

    @Provides
    @Singleton
    fun provideSignInUseCase(loginRepository: LoginRepository): SignInUserUseCase = SignInUserUseCase(loginRepository)
}