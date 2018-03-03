package navanth.com.wheatherapp.presentation.whatherreport

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import navanth.com.wheatherapp.R
import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.presentation.base.BaseActivity
import navanth.com.wheatherapp.utils.Utility
import javax.inject.Inject


class WheatherReportActivity : BaseActivity(), WheatherReportContract.View {


    @Inject
    lateinit var presenter: WheatherReportPresenter
    @Inject
    lateinit var adapter: WheatherDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        setUpToolBar()
        presenter.setView(this)
        btnWhethrRept.setOnClickListener({ it -> presenter.validateCityEntered(etCity.text.toString()) })
        setAdapter()
    }

    fun setUpToolBar() {
        setSupportActionBar(toolbar)
        toolbar!!.setTitle(getString(R.string.title))
    }

    private fun setAdapter() {
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setAdapter(adapter)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getWheatherReport(wheatherResponse: WheatherResponse) {
        hideProgressDialog()
        txtCityName.text = getString(R.string.city) + wheatherResponse.city!!.name
        txtCountry.text = getString(R.string.country) + wheatherResponse.city!!.country
        adapter!!.setData(wheatherResponse)

    }

    override fun onErrorInGettingWheatherReport(errorMessage: String) {
        txtNoData.text = errorMessage
        hideProgressDialog()
    }

    override fun onValidCityEntered(city: String?) {
        Utility.hideKeyBoard(this, btnWhethrRept!!)
        showProgressDialog()
        presenter.getWheatherReport(city!!)

    }

    override fun showErrorForCityEntered(errorMessage: String) {
        etCity.error = errorMessage
    }

    override fun toggleRecyclerView(visibility: Int) {
        recyclerView.visibility = visibility
    }

    override fun toggleNoDataTextView(visibility: Int) {
        txtNoData.visibility = visibility
    }


}
