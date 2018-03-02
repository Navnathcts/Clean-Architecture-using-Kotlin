package navanth.com.wheatherapp.di.module

import dagger.Module
import dagger.Provides
import navanth.com.wheatherapp.WheatherApplication
import navanth.com.wheatherapp.di.scope.ApplicationScope

@Module
class AppModule {
    @Provides
    @ApplicationScope
    fun provideContext( context: WheatherApplication) = context
}