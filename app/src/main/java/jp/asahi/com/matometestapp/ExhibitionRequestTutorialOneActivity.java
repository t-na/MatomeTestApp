package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

public class ExhibitionRequestTutorialOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exhibition_request_tutorial_one_activity);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ExhibitionRequestTutorialTwoActivity.class);
        startActivity(intent);
    }
}
