package navanth.com.wheatherapp.di.module


import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Qualifier
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


@Module
class RxModule {
    @Provides
    @Subscription
     fun provideSubscriptionSchedule(): Scheduler {
        return Schedulers.io()

    }

    @Provides
    @Observer
    fun provideObserverScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Singleton
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    annotation class Subscription

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    annotation class Observer


}
