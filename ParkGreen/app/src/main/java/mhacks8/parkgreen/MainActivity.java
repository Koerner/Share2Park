package mhacks8.parkgreen;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import android.telephony.TelephonyManager;

import java.util.Random;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import static android.provider.AlarmClock.EXTRA_MESSAGE;



public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    Location plsWork;
    GoogleApiClient mGoogleApiClient;

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    TextView textAlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Builds class for GoogleApi
        if( mGoogleApiClient == null) {
             mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
        textAlt = (TextView) findViewById(R.id.alltitudeText);

    }
    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        System.out.println("whats");

        super.onStart();
    }

    @Override
    protected void onStop() {
        System.out.println("what");
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // EditText editText = (EditText) findViewById(R.id.edit_message);
        Random rand = new Random();
        Integer rand_num = rand.nextInt((999999-100000)+100000);
        String message = rand_num.toString(); //editText.getText().toString();
        final TelephonyManager mTelephony = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String myAndroidDeviceId = mTelephony.getDeviceId(); //this needs to be sent to the database
        float x = 1; //this needs to be sent to the database
        float y = 1; //this needs to be sent to the database
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(ConnectionResult arg0) {
        Toast.makeText(this, "Failed to connect...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        System.out.println("fuuuck");        plsWork = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (plsWork != null){
            textAlt.setText(String.valueOf((plsWork.getLatitude())));
            System.out.println(String.valueOf((plsWork.getLatitude())));
            System.out.println("greg");

        }
    }

    public void onConnectionSuspended(int arg0) {
            Toast.makeText(this, "Connection suspended...", Toast.LENGTH_SHORT).show();

    }


}

