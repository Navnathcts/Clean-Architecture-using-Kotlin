package navanth.com.wheatherapp.data.entity

import java.io.Serializable

class DataList : Serializable {
    var clouds: String? = null

    var dt: String? = null

    var humidity: String? = null

    var pressure: String? = null

    var speed: String? = null

    var deg: String? = null

    var weather: List<Weather>? = null

    var temp: Temp? = null
}