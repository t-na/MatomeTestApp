package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AssetRegistrationConfirmActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_registration_confirm_activity);
    }

    public void endAssetRegistrationConfirm(View v) {
        Intent intent = new Intent(this, AssetRegistrationActivity.class);
        startActivity(intent);
    }
}
