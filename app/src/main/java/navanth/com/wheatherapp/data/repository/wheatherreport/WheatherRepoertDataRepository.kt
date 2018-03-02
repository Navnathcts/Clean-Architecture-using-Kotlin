package navanth.com.wheatherapp.data.repository.wheatherreport

import io.reactivex.Observable
import navanth.com.wheatherapp.data.repository.DataRepository
import navanth.com.wheatherapp.domain.dashboard.WheatherReportUseCase
import javax.inject.Inject


public class WheatherRepoertDataRepository @Inject constructor() : DataRepository {
    override fun getWheatherDetailsOfCity(request: WheatherReportUseCase.Request): Observable<WheatherReportUseCase.Response> {
        return null!!
    }


}