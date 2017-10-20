package window.whr.example.com.mywindowapp.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by whrwhr446 on 20/10/2017.
 */

public class WindowConfigUtils {

    public static Rect getStatusRect(Context context){
        Rect rect = new Rect();
        ((Activity )context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    public static int getContentTop(Context context){
        return ((Activity )context).getWindow().getDecorView().findViewById(Window.ID_ANDROID_CONTENT).getTop();
    }
    public static int getContentHeight(Context context){
        return ((Activity )context).getWindow().getDecorView().findViewById(Window.ID_ANDROID_CONTENT).getHeight();
    }
    public static int getActionBarHeight(Context context){
        TypedValue tv = new TypedValue();
        int actionBarHeight = 0;
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return ((AppCompatActivity)context).getSupportActionBar().getHeight();
    }

}
