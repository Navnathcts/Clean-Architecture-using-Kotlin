package navanth.com.wheatherapp.presentation.whatherreport

import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.presentation.base.BasePresenter
import navanth.com.wheatherapp.presentation.base.BaseView


interface WheatherReportContract {

    interface Presenter : BasePresenter {

        fun setView(view: View)
        fun getWheatherReport(city: String)
    }

    interface View : BaseView<Presenter> {

        fun getWheatherReport(wheatherResponse: WheatherResponse)
        fun onErrorInGettingWheatherReport(errorMessage: String)
        fun onValidCityEntered(city :String?)
        fun showErrorForCityEntered( errorMessage: String)

        fun toggleRecyclerView(visibility:Int)
        fun toggleNoDataTextView(visibility :Int)

    }
}