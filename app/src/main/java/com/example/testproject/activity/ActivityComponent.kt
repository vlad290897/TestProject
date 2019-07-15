package com.example.testproject.activity

import com.example.testproject.MainActivity
import com.example.testproject.app.AppComponent
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
@PerActivity
interface ActivityComponent {
    fun inject(manActivity: MainActivity)
}