package jp.asahi.com.matometestapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DeliveryKitRequestActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_kit_request_activity);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.delivery_kit_request_activity_send_button:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.delivery_kit_request_activity_size_button:
                new AlertDialog.Builder(this)
                        .setTitle("サイズ表")
                        .setView(R.layout.size_image)
                        .setPositiveButton("OK", null)
                        .show();
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
