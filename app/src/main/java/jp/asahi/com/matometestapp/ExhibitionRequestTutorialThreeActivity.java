package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExhibitionRequestTutorialThreeActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exhibition_request_tutorial_three_activity);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.exhibition_request_tutorial_three_activity_cross:
                intent = new Intent(this, DeliveryKitRequestActivity.class);
                break;
            case R.id.exhibition_request_tutorial_three_activity_button:
                intent = new Intent(this, ExhibitionRequestTutorialFourActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
