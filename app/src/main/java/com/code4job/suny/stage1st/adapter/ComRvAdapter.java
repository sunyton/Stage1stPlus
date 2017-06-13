package com.code4job.suny.stage1st.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.bean.CommentInfo;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.ImageFixCallback;

import java.util.List;


/**
 * Created by suny on 2017/6/13.
 */

public class ComRvAdapter extends RecyclerView.Adapter<ComRvAdapter.MyHolder> {

    private List<CommentInfo> mList;

    public ComRvAdapter(List<CommentInfo> mList) {
        this.mList = mList;

    }

    @Override
    public ComRvAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ComRvAdapter.MyHolder holder, int position) {

        holder.tvUser.setText(mList.get(position).getUserId());
        holder.tvTime.setText(mList.get(position).getTime());
        holder.wvBody.loadDataWithBaseURL(null, mList.get(position).getComBody(), "text/html", "utf-8", null);

//        holder.richText.text(mList.get(position).getComBody());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView tvUser, tvTime;
        WebView wvBody;

        public MyHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.avator);
            wvBody = (WebView) itemView.findViewById(R.id.wv_body);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvUser = (TextView) itemView.findViewById(R.id.tv_user);
        }
    }


}
