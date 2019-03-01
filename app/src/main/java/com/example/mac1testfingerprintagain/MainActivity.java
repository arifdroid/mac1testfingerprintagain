package com.example.mac1testfingerprintagain;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FingerprintManager fingerprintManager;
    private TextView textView;

    private String resultFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultFinal="";

        Log.i("checkk","");

        textView = findViewById(R.id.textViewid);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

            FingerprintManager fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE   );

            FingerPrintHandler fingerPrintHandler = new FingerPrintHandler(this);

            fingerPrintHandler.startAuthFingerPrint(fingerprintManager);

           // FingerPrintHandler.updateText(this,"makan"); //working


            fingerPrintHandler.setPassingResultInterface(new PassingResultInterface() { //how is this triggered tho
                @Override
                public void passingResult(String s) {
                    textView.setText(s);
                }
            });
        }





    }


}
