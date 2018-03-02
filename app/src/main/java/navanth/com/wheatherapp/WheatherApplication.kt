package navanth.com.wheatherapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import navanth.com.wheatherapp.di.component.DaggerAppComponent
import javax.inject.Inject

class WheatherApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchAndroidInjector!!

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
}