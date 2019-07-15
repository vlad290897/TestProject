package com.example.testproject.activity

import android.app.Application
import com.example.testproject.Presenter
import com.example.testproject.PresenterInterface
import dagger.Module
import dagger.Provides

@Module
@PerActivity
class ActivityModule {
    @Provides
    @PerActivity
    fun providePresenter(app: Application): PresenterInterface = Presenter(app)
}