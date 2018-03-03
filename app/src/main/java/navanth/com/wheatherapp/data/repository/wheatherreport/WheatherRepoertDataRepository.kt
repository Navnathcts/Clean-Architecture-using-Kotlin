package navanth.com.wheatherapp.data.repository.wheatherreport

import io.reactivex.Observable
import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.data.repository.DataRepository
import navanth.com.wheatherapp.data.source.DataSource
import navanth.com.wheatherapp.domain.wheatherreport.WheatherReportUseCase
import javax.inject.Inject


class WheatherRepoertDataRepository @Inject constructor() : DataRepository {


    @Inject
    lateinit var dataSource: DataSource

    override fun getWheatherDetailsOfCity(request: WheatherReportUseCase.Request): Observable<WheatherReportUseCase.Response> =
            dataSource!!.getWheatherDetailsOfCity(request).map { t: WheatherResponse -> WheatherReportUseCase.Response(t) }
}