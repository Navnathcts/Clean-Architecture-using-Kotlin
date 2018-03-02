package navanth.com.wheatherapp.data.source

import io.reactivex.Observable
import navanth.com.wheatherapp.domain.dashboard.WheatherReportUseCase


public interface DataSource {

    fun getWheatherDetailsOfCity(request: WheatherReportUseCase.Request): Observable<WheatherReportUseCase.Response>

}