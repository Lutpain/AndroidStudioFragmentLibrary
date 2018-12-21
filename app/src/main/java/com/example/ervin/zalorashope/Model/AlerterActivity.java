package com.example.ervin.zalorashope.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ervin.zalorashope.R;
import com.tapadoo.alerter.Alerter;
import com.tapadoo.alerter.OnHideAlertListener;
import com.tapadoo.alerter.OnShowAlertListener;

public class AlerterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerter);
    }

    public void showAlerter(View v) {
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert Text")
                .setIcon(R.drawable.ic_android_black_24dp)
                .setBackgroundColorRes(R.color.colorAccent)
                .setDuration(5000)
                .enableSwipeToDismiss()
                .enableProgress(true)
                .setProgressColorRes(R.color.colorPrimary)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setOnShowListener(new OnShowAlertListener() {
                    @Override
                    public void onShow() {

                    }
                })
                .setOnHideListener(new OnHideAlertListener() {
                    @Override
                    public void onHide() {

                    }
                })
                .show();
    }
}
