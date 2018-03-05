package navanth.com.wheatherapp.data.source.whetherreport

import io.reactivex.Observable
import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.data.source.DataSource
import navanth.com.wheatherapp.data.source.services.WheatherReportApiService
import navanth.com.wheatherapp.domain.wheatherreport.WheatherReportUseCase
import navanth.com.wheatherapp.utils.Utility
import retrofit2.Retrofit
import javax.inject.Inject


class WheatherReportDataSourceRemote @Inject constructor() : DataSource {


    @Inject
    lateinit var retrofitObject: Retrofit

    override fun getWheatherDetailsOfCity(request: WheatherReportUseCase.Request): Observable<WheatherResponse> {

        if (request.model!!.city == null) {
            return retrofitObject!!.create(WheatherReportApiService::class.java).
                    getWheatherReportBasedOnLatLong(request!!.model!!.lat.toString(), request.model!!.lon.toString(),
                            Utility.NO_OF_DAYS_FOR_REPORT, Utility.WHEATHER_API_KEY)
        } else {
            return retrofitObject!!.create(WheatherReportApiService::class.java).
                    getWheatherReportBasedOnCityName(request!!.model!!.city!!, Utility.NO_OF_DAYS_FOR_REPORT, Utility.WHEATHER_API_KEY)
        }
    }
}