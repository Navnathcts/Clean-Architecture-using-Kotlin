package navanth.com.wheatherapp.domain.wheatherreport

import io.reactivex.Observable
import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.data.repository.DataRepository
import navanth.com.wheatherapp.domain.UseCase
import navanth.com.wheatherapp.presentation.whatherreport.model.LocationModel
import javax.inject.Inject


class WheatherReportUseCase @Inject constructor() : UseCase<WheatherReportUseCase.Request, WheatherReportUseCase.Response>() {

    @Inject
    lateinit var dataRepository: DataRepository

    override fun createObservable(request: WheatherReportUseCase.Request): Observable<WheatherReportUseCase.Response> =
            dataRepository!!.getWheatherDetailsOfCity(request)


    class Request constructor(var model: LocationModel?) : UseCase.Request

    class Response(wheatherResponse: WheatherResponse) : UseCase.Response {
        var wheatherResponse: WheatherResponse? = wheatherResponse
    }
}
