package navanth.com.wheatherapp.di.module

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.data.repository.DataRepository
import navanth.com.wheatherapp.data.repository.wheatherreport.WheatherRepoertDataRepository
import navanth.com.wheatherapp.data.source.DataSource
import navanth.com.wheatherapp.data.source.whetherreport.WheatherReportDataSourceRemote
import navanth.com.wheatherapp.presentation.base.BaseAdapter
import navanth.com.wheatherapp.presentation.whatherreport.WheatherDataAdapter
import navanth.com.wheatherapp.presentation.whatherreport.WheatherReportActivity
import navanth.com.wheatherapp.presentation.whatherreport.WheatherReportContract
import navanth.com.wheatherapp.presentation.whatherreport.WheatherReportPresenter

@Module
abstract class WheatherReportActivityModule {

    @ContributesAndroidInjector
    abstract fun provideActivity(): WheatherReportActivity

    @Binds abstract fun providePresenter(presenter: WheatherReportPresenter): WheatherReportContract.Presenter

    @Binds abstract fun provideDataRepository(wheatherRepoertDataRepository: WheatherRepoertDataRepository): DataRepository


    @Binds abstract fun provideDataSource(wheatherReportDataSourceRemote: WheatherReportDataSourceRemote): DataSource

    @Binds abstract fun provideAdapter(wheatherDataAdapter: WheatherDataAdapter): BaseAdapter<WheatherResponse>

}