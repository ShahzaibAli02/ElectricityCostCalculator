package com.electricity.costcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OutPut_Activity extends AppCompatActivity
{


    TextView txtCostPerHour;
    TextView txtCostPerDay;
    TextView txtCostPerMonth;
    TextView txtCostPerYear;
    TextView txtKwhPerDay;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_put);
        AdsManager.loadBanner(this);

        txtCostPerHour=findViewById(R.id.txtCostPerHour);
        txtCostPerDay=findViewById(R.id.txtCostPerDay);
        txtCostPerMonth=findViewById(R.id.txtCostPerMonth);
        txtCostPerYear=findViewById(R.id.txtCostPerYear);
        txtKwhPerDay=findViewById(R.id.txtKwhPerDay);




        Bundle extras = getIntent().getExtras();

        double hoursPerDay=Double.parseDouble(extras.getString("hoursPerDay"));
        double powerWatts=Double.parseDouble(extras.getString("powerWatts"));
        double kwhPrice=Double.parseDouble(extras.getString("kwhPrice"));




        double costPerHour = (powerWatts / 1000) * kwhPrice;
        double costPerDay = hoursPerDay * costPerHour;
        double costPerMonth = 30.42 * costPerDay;
        double costPerYear = 12 * costPerMonth;
        double kwhPerDay = (powerWatts / 1000) * hoursPerDay;


        txtCostPerHour.setText(String.format("%.3f",costPerHour));
        txtCostPerDay.setText(String.format("%.3f",costPerDay));
        txtCostPerMonth.setText(String.format("%.3f",costPerMonth));
        txtCostPerYear.setText(String.format("%.3f",costPerYear));
        txtKwhPerDay.setText(String.format("%.3f",kwhPerDay));


    }

    public void onClickBack (View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed () {
        super.onBackPressed();
        finish();
    }
}