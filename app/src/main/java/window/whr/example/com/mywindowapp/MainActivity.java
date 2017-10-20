package window.whr.example.com.mywindowapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private Logger logger;
    private String TAG = "MainActivity";
    private Button mButton;
    private Button mWindowBtn;
    private LinearLayout mLinearLayout;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLayoutParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger = Logger.getLogger(TAG);
        mButton = (Button) findViewById(R.id.tranparentBtn);
        mWindowBtn = (Button) findViewById(R.id.windowMenu);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TransparentActivity.class));
            }
        });
        mWindowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WindowMenuActivity.class));
            }
        });

//        mLinearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.window_test,null);
//        mWindowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
//        mLayoutParams = new WindowManager.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,
//                0,0, PixelFormat.TRANSPARENT);
//        mLayoutParams.gravity = Gravity.BOTTOM;
//        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        mLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
//
//
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (! Settings.canDrawOverlays(this)) {
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                        Uri.parse("package:" + getPackageName()));
//                startActivityForResult(intent,10);
//            }
//        }
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getApplicationContext());
//        dialogBuilder.setTitle("Warning");
//        dialogBuilder.setMessage("你被强制下线,请重新登录");
//        dialogBuilder.setCancelable(false);
//        AlertDialog alertDialog = dialogBuilder.create();
//        //需要设置AlertDialog的类型，保证在广播接收中可以正常弹出
//        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//        alertDialog.show();
//        mWindowManager.addView(mLinearLayout,mLayoutParams);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 10) {
//            if (Build.VERSION.SDK_INT >= 23) {
//                if (!Settings.canDrawOverlays(this)) {
//                    // SYSTEM_ALERT_WINDOW permission not granted...
//                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getApplicationContext());
//                    dialogBuilder.setTitle("Warning");
//                    dialogBuilder.setMessage("你被强制下线,请重新登录");
//                    dialogBuilder.setCancelable(false);
//                    AlertDialog alertDialog = dialogBuilder.create();
//                    //需要设置AlertDialog的类型，保证在广播接收中可以正常弹出
//                    alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG);
//                    alertDialog.show();
//                }
//            }
//        }
//    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onStart() {
        logger.info("onStart.....");
        super.onStart();
    }

    @Override
    protected void onStop() {
        logger.info("onStop.....");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        logger.info("onDestroy.....");
        super.onDestroy();
//        mWindowManager.removeView(mLinearLayout);
    }

    @Override
    protected void onPause() {
        logger.info("onPause.....");
        super.onPause();
    }

    @Override
    protected void onResume() {
        logger.info("onResume.....");
        super.onResume();
    }
}
