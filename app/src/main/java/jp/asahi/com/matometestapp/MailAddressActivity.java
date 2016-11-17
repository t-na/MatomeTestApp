package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MailAddressActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_address_activity);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MailAddressAuthenticationActivity.class);
        startActivity(intent);
    }
}
