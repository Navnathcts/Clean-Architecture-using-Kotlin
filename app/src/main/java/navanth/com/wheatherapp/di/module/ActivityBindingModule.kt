package navanth.com.wheatherapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import navanth.com.wheatherapp.presentation.whatherreport.WheatherReportActivity


@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(WheatherReportActivityModule::class))
    abstract fun provideDashBoardActivity(): WheatherReportActivity;
}