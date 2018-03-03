package navanth.com.wheatherapp.domain.dashboard

import io.reactivex.Observable
import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.data.repository.DataRepository
import navanth.com.wheatherapp.domain.UseCase
import javax.inject.Inject


class WheatherReportUseCase @Inject constructor() : UseCase<WheatherReportUseCase.Request, WheatherReportUseCase.Response>() {

    @Inject
    lateinit var dataRepository: DataRepository

    override fun createObservable(request: WheatherReportUseCase.Request): Observable<WheatherReportUseCase.Response> =
            dataRepository!!.getWheatherDetailsOfCity(request)


    class Request constructor(val cityName: String) : UseCase.Request

    class Response(wheatherResponse: WheatherResponse) : UseCase.Response {
        var wheatherResponse: WheatherResponse? = wheatherResponse
    }
}
