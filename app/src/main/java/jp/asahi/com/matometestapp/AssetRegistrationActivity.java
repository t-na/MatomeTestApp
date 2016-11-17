package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class AssetRegistrationActivity extends ImageUploadActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_registration_activity);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView imageView = (ImageView) findViewById(R.id.delivery_kit_request_activity);
        imageView.setImageBitmap(getBitMap());
    }

    public void submitData(View v) {
        Intent intent = new Intent(this, AssetRegistrationConfirmActivity.class);
        startActivity(intent);
    }
}
