package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.setting_activity_user_information:
                intent = new Intent(this, UserInformationActivity.class);
                break;
            case R.id.setting_activity_account_information:
                intent = new Intent(this, AccountInformationActivity.class);
                break;
            case R.id.setting_activity_identity_card:
                intent = new Intent(this, IdentityCardActivity.class);
                break;
            case R.id.setting_activity_mail_address_password:
                intent = new Intent(this, MailAddressPasswordActivity.class);
                break;
            case R.id.setting_activity_collection_request:
                intent = new Intent(this, CollectionRequestActivity.class);
                break;
            case R.id.setting_activity_help:
                intent = new Intent(this, HelpActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
