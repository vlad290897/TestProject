package com.example.testproject

import com.example.testproject.activity.ActivityComponent
import com.example.testproject.activity.ActivityModule
import com.example.testproject.activity.DaggerActivityComponent
import com.example.testproject.app.AppComponent
import com.example.testproject.app.AppModule
import com.example.testproject.app.DaggerAppComponent

@Suppress("UNREACHABLE_CODE")
class DaggerInjector {


    companion object {
        private var appComponent: AppComponent? = null
        fun getAppComponent(): AppComponent? {
            appComponent = DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
            return appComponent
        }

        fun getActivityComponent(): ActivityComponent {
            return DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(ActivityModule())
                .build()
        }
    }
}