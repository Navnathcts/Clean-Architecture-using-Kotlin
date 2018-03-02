package navanth.com.wheatherapp.presentation.whatherreport

import android.os.Bundle
import android.util.Log
import navanth.com.wheatherapp.R
import navanth.com.wheatherapp.presentation.base.BaseActivity
import javax.inject.Inject

class WheatherReportActivity : BaseActivity(), WheatherReportContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun showSpinner() {
    }

    override fun hideSpinner() {

    }

}
