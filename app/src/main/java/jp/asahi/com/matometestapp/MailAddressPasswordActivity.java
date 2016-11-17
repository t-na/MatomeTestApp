package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MailAddressPasswordActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_address_password_activity);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.mail_address_password_activity_address_button:
                intent = new Intent(this, MailAddressActivity.class);
                break;
            case R.id.mail_address_password_activity_password_button:
                intent = new Intent(this, PasswordActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
