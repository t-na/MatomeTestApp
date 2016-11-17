package jp.asahi.com.matometestapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdentityCardActivity extends TabFooterActivity {

    private Uri bitmapUri;
    private Bitmap bm;

    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identity_card_activity);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.identity_card_activity_button:
                intent = new Intent(this, IdentityCardConfirmActivity.class);
                break;
            case R.id.identity_card_activity_surface_button:
                makeToastToSelect(v);
                break;
            case R.id.identity_card_activity_back_button:
                makeToastToSelect(v);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    private void makeToastToSelect(final View v) {
        String[] str_items = {"カメラで撮影", "ギャラリーの選択", "キャンセル"};
        new AlertDialog.Builder(this)
                .setTitle("写真をアップロード")
                .setItems(str_items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                // カメラ起動
                                checkPermission(v, MY_PERMISSIONS_REQUEST_CAMERA);
                                break;
                            case 1:
                                // ギャラリー起動
                                checkPermission(v, MY_PERMISSIONS_REQUEST_WRITE_STORAGE);
                                break;
                            default:
                                // キャンセルを選んだ場合
                                break;
                        }
                    }
                }).show();
    }

    private void checkPermission(View v, int requestCode) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA) {
            // Android 6.0以上の場合
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "カメラ権限の取得は既に許可されています", Toast.LENGTH_SHORT).show();
                    wakeupCamera();
                } else {
                    // なければ権限を求めるダイアログを表示
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            MY_PERMISSIONS_REQUEST_CAMERA);
                }
                // Android 6.0以下の場合
            } else {
                // インストール時点で許可されているのでチェックの必要なし
                Toast.makeText(this, "カメラ権限の取得は既に許可されています(Android 5.x以下です)", Toast.LENGTH_SHORT).show();
                wakeupCamera();
            }
        } else if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_STORAGE) {
            // Android 6.0以上の場合
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "権限のストレージ取得は既に許可されています", Toast.LENGTH_SHORT).show();
                    wakeupGallery();
                } else {
                    // なければ権限を求めるダイアログを表示
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            MY_PERMISSIONS_REQUEST_WRITE_STORAGE);
                }
                // Android 6.0以下の場合
            } else {
                // インストール時点で許可されているのでチェックの必要なし
                Toast.makeText(this, "ストレージ権限の取得は既に許可されています(Android 5.x以下です)", Toast.LENGTH_SHORT).show();
                wakeupGallery();
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA) {
            // 許可されたら
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "カメラ権限取得が許可されました", Toast.LENGTH_SHORT).show();
                wakeupCamera();
                // 許可されなかったら
            } else {
                Toast.makeText(this, "カメラ権限取得が拒否されました", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_STORAGE) {
            // 許可されたら
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "ストレージ権限取得が許可されました", Toast.LENGTH_SHORT).show();
                wakeupGallery();
                // 許可されなかったら
            } else {
                Toast.makeText(this, "ストレージ権限取得が拒否されました", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void wakeupCamera() {
        File mediaStorageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES
                ), "PictureSaveDir"
        );
        if (!mediaStorageDir.exists() & !mediaStorageDir.mkdir()) {
            return;
        }
        String timeStamp = new SimpleDateFormat("yyyMMddHHmmss").format(new Date());
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + timeStamp + ".JPG");
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        bitmapUri = Uri.fromFile(mediaFile);
        i.putExtra(MediaStore.EXTRA_OUTPUT, bitmapUri); // 画像をmediaUriに書き込み
        startActivityForResult(i, MY_PERMISSIONS_REQUEST_CAMERA);
    }

    private void wakeupGallery() {
        Intent i = new Intent();
        i.setType("image/*"); // 画像のみが表示されるようにフィルターをかける
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, MY_PERMISSIONS_REQUEST_WRITE_STORAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (bm != null)
                bm.recycle(); // 直前のBitmapが読み込まれていたら開放する

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4; // 元の1/4サイズでbitmap取得

            switch (requestCode) {
                case 1: // カメラの場合
                    bm = BitmapFactory.decodeFile(bitmapUri.getPath(), options);
                    // 撮影した画像をギャラリーのインデックスに追加されるようにスキャンする。
                    // これをやらないと、アプリ起動中に撮った写真が反映されない
                    String[] paths = {bitmapUri.getPath()};
                    String[] mimeTypes = {"image/*"};
                    MediaScannerConnection.scanFile(getApplicationContext(), paths, mimeTypes, new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                        }
                    });
                    break;
                case 2: // ギャラリーの場合
                    try {
                        ContentResolver cr = getContentResolver();
                        String[] columns = {MediaStore.Images.Media.DATA};
                        Cursor c = cr.query(data.getData(), columns, null, null, null);
                        c.moveToFirst();
                        bitmapUri = Uri.fromFile(new File(c.getString(0)));
                        InputStream is = getContentResolver().openInputStream(data.getData());
                        bm = BitmapFactory.decodeStream(is, null, options);
                        is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

            ImageView imageView = (ImageView) findViewById(R.id.identity_card_activity_image);
            imageView.setImageBitmap(bm);
        }
    }
}
