package com.example.testproject.app

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(): Application = Application()
}