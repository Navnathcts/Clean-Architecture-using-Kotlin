package navanth.com.wheatherapp.presentation.whatherreport

import navanth.com.wheatherapp.presentation.base.BasePresenter
import navanth.com.wheatherapp.presentation.base.BaseView


 interface WheatherReportContract {

    interface Presenter : BasePresenter<View> {

    }

    interface View : BaseView<Presenter> {

    }
}