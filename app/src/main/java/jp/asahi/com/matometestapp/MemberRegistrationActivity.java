package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_registration_activity);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, AuthenticationMailActivity.class);
        startActivity(intent);
    }
}
