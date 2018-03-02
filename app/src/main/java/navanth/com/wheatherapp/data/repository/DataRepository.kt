package navanth.com.wheatherapp.data.repository

import io.reactivex.Observable
import navanth.com.wheatherapp.domain.dashboard.WheatherReportUseCase


public interface DataRepository {

    fun getWheatherDetailsOfCity(request: WheatherReportUseCase.Request): Observable<WheatherReportUseCase.Response>

}