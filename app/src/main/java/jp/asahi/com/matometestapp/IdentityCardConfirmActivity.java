package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class IdentityCardConfirmActivity extends TabFooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_card_confirm_activity);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        imageAdjust();
    }

    public void imageAdjust() {
        ImageView surface = (ImageView) findViewById(R.id.identity_card_confirm_activity_card_surface);
        ImageView back = (ImageView) findViewById(R.id.identity_card_confirm_activity_card_back);
        surface.getLayoutParams().height = ((FrameLayout) surface.getParent()).getMeasuredHeight();
        back.getLayoutParams().height = ((FrameLayout) back.getParent()).getMeasuredHeight();
    }
}
