package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TabFooterActivity extends AppCompatActivity {
    public void OnClickTabButton(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tab_layout_home:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_registration:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_notification:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_setting:
                intent = new Intent(this, SettingActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
