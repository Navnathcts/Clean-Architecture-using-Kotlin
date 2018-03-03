package navanth.com.wheatherapp.presentation.whatherreport

import android.text.TextUtils
import android.view.View
import io.reactivex.disposables.CompositeDisposable
import navanth.com.wheatherapp.domain.wheatherreport.WheatherReportUseCase
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
                    view!!.toggleRecyclerView(View.VISIBLE)
                    view!!.toggleNoDataTextView(View.GONE)
                    view!!.getWheatherReport(response.wheatherResponse!!)
                },
                { throwable ->
                    view!!.toggleRecyclerView(View.GONE)
                    view!!.toggleNoDataTextView(View.VISIBLE)
                    view!!.onErrorInGettingWheatherReport(" Oops !! Unable to fetch wheather details... ");
                }))
    }

    fun validateCityEntered(city: String?) {
        if (TextUtils.isEmpty(city)) {
            view!!.showErrorForCityEntered("Please enter city name ");
        } else {
            view!!.onValidCityEntered(city!!)
        }

    }


}
