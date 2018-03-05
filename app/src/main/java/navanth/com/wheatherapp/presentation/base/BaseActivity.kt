package navanth.com.wheatherapp.presentation.base

import android.Manifest
import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.location.*
import dagger.android.support.DaggerAppCompatActivity
import navanth.com.wheatherapp.presentation.whatherreport.model.LocationModel
import navanth.com.wheatherapp.utils.Utility
import navanth.com.wheatherapp.utils.Utility.Companion.LOCATION_DISTANCE
import navanth.com.wheatherapp.utils.Utility.Companion.LOCATION_INTERVAL
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity(), GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, ResultCallback<LocationSettingsResult>, LocationListener {


    private val REQUEST_LOCATION_PERMISSION = 99
    private val REQUEST_LOCATION_DIALOG = 101
    lateinit var mGoogleApiClient: GoogleApiClient
    @Inject
    lateinit var mLocationRequestBuilder: LocationSettingsRequest.Builder
    @Inject
    lateinit var locationRequest: LocationRequest
    lateinit var mLocationManager: LocationManager
    protected var locationObject: LocationModel? = null
    lateinit var provideCurrentLocation: ProvideCurrentLocation

    lateinit var mProgressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mProgressDialog = Utility.getProgressDialogInstance(this)
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build()
        mLocationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    fun showProgressDialog(message: String) {
        mProgressDialog!!.setMessage(message)
        mProgressDialog.show()
    }

    fun hideProgressDialog() {
        mProgressDialog!!.dismiss()
    }

    abstract fun getLayoutId(): Int


    fun checkLocationPermission(provideCurrentLocation: ProvideCurrentLocation): Boolean {
        this.provideCurrentLocation = provideCurrentLocation
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_LOCATION_PERMISSION)
            return false
        } else {
            displayLocationSettingsRequest()
            return true
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_LOCATION_PERMISSION -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        displayLocationSettingsRequest()
                    }
                }
            }
            else -> finish()
        }
    }

    private fun displayLocationSettingsRequest() {
        mGoogleApiClient.connect()
        var result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, mLocationRequestBuilder.build())
        result.setResultCallback(this)
    }

    @SuppressLint("MissingPermission")
    override fun onResult(locationSettingsResult: LocationSettingsResult) {
        val status = locationSettingsResult.status
        when (status.statusCode) {
            LocationSettingsStatusCodes.SUCCESS -> {
                LocationServices.FusedLocationApi!!.requestLocationUpdates(mGoogleApiClient!!, locationRequest!!, this)
                requestLocationUpdates()
            }
            LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
                Log.i("Location", "Location settings are not satisfied. Show the user a dialog to upgrade location settings ")
                try {
                    status.startResolutionForResult(this, REQUEST_LOCATION_DIALOG)
                } catch (e: IntentSender.SendIntentException) {
                    e.printStackTrace()
                }

            }
            LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> Log.i("Location", "Location settings are inadequate, and cannot be fixed here. Dialog not created.")
        }
    }

    private fun requestLocationUpdates() {
        try {
            mLocationManager!!.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE, LocationListener(LocationManager.GPS_PROVIDER))
            mLocationManager!!.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE, LocationListener(LocationManager.NETWORK_PROVIDER))
        } catch (ex: java.lang.SecurityException) {
            Log.i("Location", "fail to request location update, ignore", ex)
        } catch (ex: IllegalArgumentException) {
            Log.d("Location", "gps provider does not exist " + ex.message)
        }

    }

    override fun onLocationChanged(location: Location?) {
        Log.d("Location", "onChanged : " + location!!)
        setUpLocationModel(location)
    }

    @SuppressLint("MissingPermission")
    override fun onConnected(p0: Bundle?) {
        val location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient)
        setUpLocationModel(location)
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, this)
    }

    override fun onConnectionSuspended(p0: Int) {
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
    }

    inner class LocationListener(provider: String) : android.location.LocationListener {

        internal var mLastLocation: android.location.Location

        init {
            mLastLocation = Location(provider)
        }

        override fun onLocationChanged(location: Location?) {
            setUpLocationModel(location)
        }

        override fun onProviderDisabled(provider: String) {}

        override fun onProviderEnabled(provider: String) {}

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

        }
    }

    interface ProvideCurrentLocation {
        fun getCurrentLocation(locationModel: LocationModel?)
    }

    fun setUpLocationModel(location: Location?) {
        if (location != null) {
            hideProgressDialog()
            locationObject = LocationModel(null, location.latitude, location.longitude)
            provideCurrentLocation.getCurrentLocation(locationObject)
        }
    }

}