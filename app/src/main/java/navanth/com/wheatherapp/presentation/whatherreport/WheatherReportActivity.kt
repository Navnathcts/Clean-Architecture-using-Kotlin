package navanth.com.wheatherapp.presentation.whatherreport

import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import navanth.com.wheatherapp.R
import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.presentation.base.BaseActivity
import javax.inject.Inject


class WheatherReportActivity : BaseActivity(), WheatherReportContract.View {

    @Inject
    lateinit var presenter: WheatherReportPresenter
    @Inject
    lateinit var adapter: WheatherDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        presenter.setView(this)
        presenter.getWheatherReport("Pune")
        setAdapter()
    }

    private fun setAdapter() {
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setAdapter(adapter)
    }

    override fun showSpinner() {
    }

    override fun hideSpinner() {
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getWheatherReport(wheatherResponse: WheatherResponse) {
        Log.d("response", " called")
        adapter!!.setData(wheatherResponse)

    }

    override fun onErrorInGettingWheatherReport(errorMessage: String) {
        adapter!!.setData(null!!)
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

}
