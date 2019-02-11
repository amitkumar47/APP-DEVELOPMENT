package com.example.ak47.sms;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText t;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




        public void call (View view){
            EditText editText = (EditText) findViewById(R.id.number);
            // Use format with "tel:" and phone number to create phoneNumber.
            String phoneNumber = String.format("tel: %s",
                    editText.getText().toString());
            // Log the concatenated phone number for dialing.
            //  Log.d(TAG, getString(R.string.dial_number) + phoneNumber);
//        Toast.makeText(this,
//                getString(R.string.dial_number) + phoneNumber,
//                Toast.LENGTH_LONG).show();
            // Create the intent.
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            // Set the data for the intent as the phone number.
            callIntent.setData(Uri.parse(phoneNumber));
            // If package resolves to an app, send intent.
            if (callIntent.resolveActivity(getPackageManager()) != null) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                  //   TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            } else {
                // Log.e(TAG, "Can't resolve app for ACTION_CALL Intent.");
            }

        }}

