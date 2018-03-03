package navanth.com.wheatherapp.presentation.whatherreport

import android.provider.Settings.Global.getString
import android.support.v7.widget.RecyclerView
import android.view.View
import navanth.com.wheatherapp.data.entity.DataList
import kotlinx.android.synthetic.main.list_row.view.*
import navanth.com.wheatherapp.R
import navanth.com.wheatherapp.utils.Utility
import java.text.DecimalFormat


class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindData(dataModel: DataList) {
        itemView.itemDate.text = Utility.getDate(dataModel.dt!!.toLong())
        itemView.itemDescription.text = dataModel.weather!!.get(0).description
        itemView.itemHumidity.text = "Humidity : " + dataModel.humidity + " %"
        itemView.itemWind.text = "Wind : " + dataModel.speed + " m/s"
        itemView.itemTemperature.text = DecimalFormat("#.##").format(dataModel.temp!!.day!!.toFloat() - 273.15f) + " °C"
        itemView.itemPressure.text = "Pressure : " + dataModel.pressure!! + " kPa"
    }
}