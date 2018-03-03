package navanth.com.wheatherapp.utils

import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


class Utility {

    companion object {
        var WHEATHER_API_KEY = "bd153e8496e41dbc64438ca6b74f2550"
        var NO_OF_DAYS_FOR_REPORT = "14"
        var BASE_URL = "http://api.openweathermap.org/data/2.5/"
        var mProgressDialog: ProgressDialog? = null

        fun getProgressDialogInstance(context: Context): ProgressDialog {
            mProgressDialog = ProgressDialog(context)
            mProgressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            mProgressDialog!!.setMessage("Please wait...")
            mProgressDialog!!.setCanceledOnTouchOutside(false)
            return mProgressDialog!!
        }

        fun getDate(timestamp: Long): String {
            var calendar = Calendar.getInstance()
            calendar.timeInMillis = timestamp * 1000L
            return SimpleDateFormat("dd-MMM-yyyy ").format(calendar.time)

        }

        fun hideKeyBoard(context: Context, view: View) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}