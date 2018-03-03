package navanth.com.wheatherapp.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.ArrayList

class WheatherResponse : Serializable {
    var message: String? = null

    var cnt: String? = null

    var cod: String? = null

    var list: ArrayList<DataList>? = null

    var city: City? = null


}
