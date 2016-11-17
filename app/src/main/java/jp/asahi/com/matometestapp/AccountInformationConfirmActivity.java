package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AccountInformationConfirmActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_information_confirm_activity);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, AccountInformationActivity.class);
        startActivity(intent);
    }
}
