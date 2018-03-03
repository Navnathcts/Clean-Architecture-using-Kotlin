package navanth.com.wheatherapp.presentation.whatherreport

import android.util.Log
import android.view.View
import io.reactivex.disposables.CompositeDisposable
import navanth.com.wheatherapp.domain.dashboard.WheatherReportUseCase
import javax.inject.Inject


class WheatherReportPresenter @Inject constructor() : WheatherReportContract.Presenter {


    var compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var wheatherRepostUseCase: WheatherReportUseCase

    companion object {
        var view: WheatherReportContract.View? = null
    }

    override fun setView(view: WheatherReportContract.View) {
        WheatherReportPresenter.view = view
    }


    override fun getWheatherReport(cityName: String) {
        compositeDisposable!!.add(wheatherRepostUseCase!!.
                executeUseCase(WheatherReportUseCase.Request(cityName)).subscribe(
                { response ->
                    view!!.getWheatherReport(response.wheatherResponse!!)
                },
                { throwable ->
                    view!!.onErrorInGettingWheatherReport(" Oops !! Unable to fetch wheather details... ");
                }))
    }


}
