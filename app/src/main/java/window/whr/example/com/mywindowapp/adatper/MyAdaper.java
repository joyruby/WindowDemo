package window.whr.example.com.mywindowapp.adatper;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import window.whr.example.com.mywindowapp.R;
import window.whr.example.com.mywindowapp.model.ListEntity;

import static android.R.attr.data;

/**
 * Created by whrwhr446 on 18/10/2017.
 */

public class MyAdaper extends RecyclerView.Adapter {
    private List<ListEntity> mData;
    private Context mContext;
    private int IMAGE = 0;
    private int LIST = 1;

    public MyAdaper(Context context, List<ListEntity> data) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {

        return position == 0 ? IMAGE : LIST;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if(viewType == IMAGE){
            viewHolder = new ItemImageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_image,null));
        }else{
            viewHolder = new ItemListViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list,null));

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemListViewHolder){
            ((ItemListViewHolder) holder).initView(mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class ItemImageViewHolder extends RecyclerView.ViewHolder{

        public ItemImageViewHolder(View itemView) {
            super(itemView);
        }
    }
    class ItemListViewHolder extends RecyclerView.ViewHolder{
        TextView name, date, info;
        SimpleDraweeView avatar, infoImage;
        public ItemListViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar_image);
            infoImage = itemView.findViewById(R.id.info_image);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            info = itemView.findViewById(R.id.info);
        }
        public void initView(ListEntity entity){

            name.setText(entity.name);
            date.setText(entity.date);
            info.setText(entity.info);
            avatar.setImageURI(Uri.parse(entity.avatarUrl));
            infoImage.setImageURI(Uri.parse(entity.infoUrl));
        }
    }
}
