package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.login_activity_login_button:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.login_activity_member_registration:
                intent = new Intent(this, MemberRegistrationActivity.class);
                break;
            case R.id.login_activity_password_forgetting:
                intent = new Intent(this, PasswordForgettingActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
