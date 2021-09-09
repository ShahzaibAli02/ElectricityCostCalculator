package com.electricity.costcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;

public class MainActivity extends AppCompatActivity
{


    EditText editTextHoursPerDay;
    EditText editTextPowerUse;
    EditText editTextPrice;
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdsManager.loadBanner(this);
        editTextHoursPerDay=findViewById(R.id.editTextHoursPerDay);
        editTextPowerUse=findViewById(R.id.editTextPowerUse);
        editTextPrice=findViewById(R.id.editTextPrice);


    }

    public void onClickCalculate (View view)
    {

        for(EditText editText:new EditText[]{editTextHoursPerDay,editTextPowerUse,editTextPrice})
        {
            if(TextUtils.isEmpty(editText.getText()))
            {
                editText.setError("Required Field");
                editText.requestFocus();
                return;
            }
        }


        if(AdsManager.getInterstatial()!=null)
        {
            AdsManager.getInterstatial().setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdDismissedFullScreenContent() {
                AdsManager.loadInterstatial();
                goToNextActivity();
            }

            @Override
            public void onAdFailedToShowFullScreenContent (AdError adError) {
                AdsManager.loadInterstatial();
                goToNextActivity();
            }

            @Override
            public void onAdShowedFullScreenContent() {

            }


        });


            AdsManager.getInterstatial().show(this);
        }
        else
        {
            goToNextActivity();
            AdsManager.loadInterstatial();
        }


    }

    private void goToNextActivity ()
    {

        Intent n=new Intent(MainActivity.this,OutPut_Activity.class);
        n.putExtra("powerWatts",editTextPowerUse.getText().toString());
        n.putExtra("hoursPerDay",editTextHoursPerDay.getText().toString());
        n.putExtra("kwhPrice",editTextPrice.getText().toString());
        startActivity(n);
    }
}