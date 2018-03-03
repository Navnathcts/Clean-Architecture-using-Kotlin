package navanth.com.wheatherapp.presentation.whatherreport

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import navanth.com.wheatherapp.R
import navanth.com.wheatherapp.data.entity.DataList
import navanth.com.wheatherapp.data.entity.WheatherResponse
import navanth.com.wheatherapp.presentation.base.BaseAdapter
import javax.inject.Inject


class WheatherDataAdapter @Inject constructor() : BaseAdapter<WheatherResponse>, RecyclerView.Adapter<WeatherViewHolder>() {

    var itemList: List<DataList>? = null


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): WeatherViewHolder = WeatherViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.list_row, null))


    override fun onBindViewHolder(viewHolder: WeatherViewHolder, position: Int) {
        viewHolder.bindData(itemList!!.get(position))
    }

    override fun getItemCount(): Int = itemList?.size ?: 0

    override fun setData(response: WheatherResponse) {
        itemList = response.list!!
        notifyDataSetChanged()
    }
}