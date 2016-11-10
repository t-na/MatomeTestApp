package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExhibitionRequestTutorialFourActivity extends AppCompatActivity implements TabClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exhibition_request_tutorial_four_activity);
    }

    @Override
    public void OnClickTabButton(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tab_layout_home:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_registration:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_notification:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_setting:
                intent = new Intent(this, HomeActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.exhibition_request_tutorial_four_activity_cross:
                intent = new Intent(this, DeliveryKitRequestActivity.class);
                break;
            case R.id.exhibition_request_tutorial_four_activity_button:
                intent = new Intent(this, ExhibitionRequestTutorialFiveActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
