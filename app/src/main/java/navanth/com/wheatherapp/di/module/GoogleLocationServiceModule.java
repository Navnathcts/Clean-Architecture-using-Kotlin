package navanth.com.wheatherapp.di.module;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;

import dagger.Module;
import dagger.Provides;
import navanth.com.wheatherapp.utils.Utility;

@Module
public class GoogleLocationServiceModule {

    @Provides
    LocationRequest providesLocationSettingsRequest() {
        return LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(Utility.Companion.getLOCATION_INTERVAL())
                .setFastestInterval(Utility.Companion.getLOCATION_INTERVAL());
    }

    @Provides
    LocationSettingsRequest.Builder provideLocationSettingsBuilder() {
        return new LocationSettingsRequest.Builder().addLocationRequest(providesLocationSettingsRequest()).setAlwaysShow(true);
    }

}
