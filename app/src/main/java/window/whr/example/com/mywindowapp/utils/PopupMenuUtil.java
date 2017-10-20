package window.whr.example.com.mywindowapp.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PixelFormat;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import window.whr.example.com.mywindowapp.R;

/**
 * Created by whrwhr446 on 19/10/2017.
 */

public class PopupMenuUtil implements View.OnClickListener {

    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLayoutParams;
    private RelativeLayout rootView;
    private RelativeLayout addBtn;
    private ImageView addUi;
    private Boolean isShowing = false;
    private LinearLayout upOne;
    private LinearLayout upTwo;
    private LinearLayout upThree;
    private LinearLayout upFour;
    private LinearLayout downOne;
    private LinearLayout downTwo;
    private LinearLayout downThree;
    private LinearLayout downFour;
    private int up = -1;
    private int down = -1;
    private static PopupMenuUtil INSTANCE = new PopupMenuUtil();
    public static PopupMenuUtil getInstance(){
        return INSTANCE;
    }


    private void initPopupMenu(Context context) {
        rootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.popup_menu, null);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Toast.makeText(context,"actionbar :"+getContentTop(context),Toast.LENGTH_LONG);
        mLayoutParams  = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowConfigUtils.getContentHeight(context),0,WindowConfigUtils.getContentTop(context), 0, 0, PixelFormat.TRANSPARENT);
        mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION;
        mLayoutParams.x =0;
        mLayoutParams.y =300;
        mWindowManager.addView(rootView,mLayoutParams);

        if(up == -1 && down == -1){
            up = dip2px(context,310);
            down = dip2px(context,210);
        }


        addBtn = rootView.findViewById(R.id.pop_rl_click);
        addUi = rootView.findViewById(R.id.pop_iv_img);
        //up
        upOne = rootView.findViewById(R.id.test1);
        upTwo = rootView.findViewById(R.id.test2);
        upThree = rootView.findViewById(R.id.test3);
        upFour = rootView.findViewById(R.id.test4);
        //down
        downOne = rootView.findViewById(R.id.test5);
        downTwo = rootView.findViewById(R.id.test6);
        downThree = rootView.findViewById(R.id.test7);
        downFour = rootView.findViewById(R.id.test8);
        //action
        addUi.setOnClickListener(this);
    }

    public void show(Context context){
        if(isShowing){
            return;
        }
        initPopupMenu(context);
        rotateBtn(0f,135f);
        //up
        moveAnim(upOne,400,down,0f);
        moveAnim(upFour,400,down,0f);
        moveAnim(upTwo,500,down,0f);
        moveAnim(upThree,500,down,0f);

        //down
        moveAnim(downOne,400,down,0f);
        moveAnim(downFour,400,down,0f);
        moveAnim(downThree,500,down,0f);
        moveAnim(downTwo,500,down,0f);

        isShowing = true;
    }

    public void close(){
        if(!isShowing){
            return;
        }
        rotateBtn(135f,0f);

        //up
        moveAnim(upOne,500,0f,up);
        moveAnim(upFour,500,0f,up);
        moveAnim(upTwo,400,0f,up);
        moveAnim(upThree,400,0f,up);

        //down
        moveAnim(downOne,500,0f,down);
        moveAnim(downFour,500,0f,down);
        moveAnim(downThree,400,0f,down);
        moveAnim(downTwo,400,0f,down);
        rootView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mWindowManager.removeView(rootView);
            }
        },500);
        isShowing = false;
    }

    public void rotateBtn(float startDegree, float endDegree){
        ObjectAnimator anim = ObjectAnimator.ofFloat(addUi,"rotation",startDegree,endDegree);
        anim.setDuration(300);
        anim.start();
    }

    private void moveAnim(View view ,int duration, float startP, float endP){
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY",startP,endP);
        anim.setDuration(duration);
        anim.start();
    }


    private int getContentTop(Context context){
        return WindowConfigUtils.getContentTop(context) - WindowConfigUtils.getActionBarHeight(context);
    }

    private int dip2px(Context context,float dp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp*density+0.5f);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pop_iv_img:
                close();
                break;
        }
    }
}
