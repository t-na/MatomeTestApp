package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AssetRegistrationActivity extends ImageUploadActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_registration_activity);
    }

    public void submitData(View v) {
        Intent intent = new Intent(this, AssetRegistrationConfirmActivity.class);
        startActivity(intent);
    }
}
