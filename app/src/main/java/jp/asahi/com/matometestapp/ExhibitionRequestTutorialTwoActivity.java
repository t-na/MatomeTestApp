package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExhibitionRequestTutorialTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exhibition_request_tutorial_two_activity);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ExhibitionRequestTutorialThreeActivity.class);
        startActivity(intent);
    }
}
