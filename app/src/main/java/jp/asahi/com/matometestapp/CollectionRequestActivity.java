package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CollectionRequestActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_request_activity);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.collection_request_activity_yamato:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"));
                break;
            case R.id.collection_request_activity_sagawa:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0000000000"));
                break;
            case R.id.collection_request_activity_yuupack:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5555555555"));
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
