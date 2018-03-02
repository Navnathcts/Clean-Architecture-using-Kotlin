package navanth.com.wheatherapp.data.source.whetherreport

import io.reactivex.Observable
import navanth.com.wheatherapp.data.source.DataSource
import navanth.com.wheatherapp.domain.dashboard.WheatherReportUseCase
import javax.inject.Inject


public class WheatherReportDataSourceRemote @Inject constructor() : DataSource {
    override fun getWheatherDetailsOfCity(request: WheatherReportUseCase.Request): Observable<WheatherReportUseCase.Response> {
        return null!!
    }
}