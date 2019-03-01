package com.example.mac1testfingerprintagain;

import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.widget.TextView;

class FingerPrintHandler extends FingerprintManager.AuthenticationCallback {

    private Context mContext;

    private PassingResultInterface passingResultInterface;

    public void setPassingResultInterface(PassingResultInterface passingResultInterface){
        this.passingResultInterface =passingResultInterface;
    }


    //you can't update things on the ui thread from anywhere but the ui thread



    public FingerPrintHandler(Context context) {

        this.mContext = context;


    }


    public void startAuthFingerPrint(FingerprintManager fingerprintManager){

        CancellationSignal cancellationSignal = new CancellationSignal();

        fingerprintManager.authenticate(null,cancellationSignal,0,this,null);

    }


    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);

        if(passingResultInterface!=null){
                passingResultInterface.passingResult("error la");
        }

    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);
        if(passingResultInterface!=null){
            passingResultInterface.passingResult("error la");
        }
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);

        if(passingResultInterface!=null){
            passingResultInterface.passingResult("success");
        }
    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();

        if(passingResultInterface!=null){
            passingResultInterface.passingResult("fail la");
        }
    }

//    public static void updateText(Activity activity,String result){
//
//        TextView textView = (TextView)((Activity)activity).findViewById(R.id.textViewid);
//
//        textView.setText("test");
//
//    }
}

