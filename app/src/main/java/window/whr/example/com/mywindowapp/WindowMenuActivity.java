package window.whr.example.com.mywindowapp;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import window.whr.example.com.mywindowapp.adatper.MyAdaper;
import window.whr.example.com.mywindowapp.model.ListEntity;
import window.whr.example.com.mywindowapp.utils.PopupMenuUtil;

public class WindowMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private ImageButton mAddBtn;
    private List<ListEntity> mData;
    private MyAdaper adapter;
    private PopupMenuUtil popUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_menu);
        mContext = this;
        initViews();
        initData();
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAddBtn = (ImageButton) findViewById(R.id.addBtn);
        mAddBtn.setOnClickListener(this);
        popUp = PopupMenuUtil.getInstance();
    }
    private void initData() {
        mData= new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mData.add(new ListEntity());

        for(int i=0;i<20;i++){
            ListEntity listEntity=new ListEntity();
            listEntity.name="八千米海岸";
            listEntity.date="10月25日12:25";
            listEntity.info="追求随性的路上还不够洒脱。记得所有的好，感谢所遇到的一切";

            listEntity.infoUrl="http://img2.imgtn.bdimg.com/it/u=2452097355,3155741241&fm=21&gp=0.jpg";
            listEntity.avatarUrl="http://img4.imgtn.bdimg.com/it/u=2373780812,700019726&fm=21&gp=0.jpg";

            mData.add(listEntity);
        }
        setAdapter();
    }

    public void setAdapter(){
        if(adapter == null){
            adapter = new MyAdaper(this,mData);
            mRecyclerView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addBtn:
                popUp.show(mContext);
                break;
        }
    }
}
