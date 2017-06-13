package com.code4job.suny.stage1st.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.code4job.suny.stage1st.CommentActivity;
import com.code4job.suny.stage1st.MainActivity;
import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.bean.ListInfo;

import java.util.List;

/**
 * Created by suny on 2017/6/11.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {

    private List<ListInfo> mListInfos;
    private Context mContext;

    public ListAdapter(List<ListInfo> list, Context context) {
        mContext = context;
        this.mListInfos = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.tvReply.setText(mListInfos.get(position).getReplyNum());
        holder.tvBody.setText(mListInfos.get(position).getTpBody());
        holder.tvRead.setText(mListInfos.get(position).getReadNum());
        holder.tvUserId.setText(mListInfos.get(position).getUserName());
        holder.tvTpic.setText(mListInfos.get(position).getTopicName());
        holder.tvTime.setText(mListInfos.get(position).getReplyDate());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CommentActivity.class);
                intent.putExtra("url", mListInfos.get(position).getUrl());
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mListInfos.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvUserId,tvTpic,tvTime,tvBody,tvReply, tvRead;
        CardView mCardView;
        public MyHolder(View itemView) {
            super(itemView);
            tvBody = (TextView) itemView.findViewById(R.id.topicBody);
            tvUserId = (TextView) itemView.findViewById(R.id.userId);
            tvTpic = (TextView) itemView.findViewById(R.id.topicName);
            tvTime = (TextView) itemView.findViewById(R.id.replyTime);
            tvRead = (TextView) itemView.findViewById(R.id.readNum);
            tvReply = (TextView) itemView.findViewById(R.id.commentNum);
            mCardView = (CardView) itemView.findViewById(R.id.cv_list);
        }
    }
}
