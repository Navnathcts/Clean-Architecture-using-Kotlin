package navanth.com.wheatherapp.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import navanth.com.wheatherapp.WheatherApplication
import navanth.com.wheatherapp.di.module.ActivityBindingModule
import navanth.com.wheatherapp.di.module.AppModule
import navanth.com.wheatherapp.di.module.GoogleLocationServiceModule
import navanth.com.wheatherapp.di.module.RetrofitModule
import navanth.com.wheatherapp.di.scope.ApplicationScope
import javax.inject.Singleton


@Singleton
@ApplicationScope
@Component(modules = arrayOf(
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        GoogleLocationServiceModule::class,
        RetrofitModule::class))
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(wheatherApplication: WheatherApplication)

    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent;
    }
}