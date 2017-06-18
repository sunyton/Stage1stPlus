package com.code4job.suny.stage1st.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.utils.Constants;

import java.util.List;
import java.util.Map;

/**
 * Created by suny on 2017/6/16.
 */

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVAdapter.Holder> {

    private String[] homeList;
    private SharedPreferences sp;

    public HomeRVAdapter(String[] homeList, Context context) {
        this.homeList = homeList;
        sp = context.getSharedPreferences("topic", Context.MODE_PRIVATE);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        Holder hoder = new Holder(view);
        return hoder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        holder.tvName.setText(homeList[position]);
        if (sp.contains(homeList[position])) {
            holder.imStar.setChecked(true);

        }
        holder.imStar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sp.edit();
                if (isChecked) {

                    editor.putString(homeList[position], Constants.getUrl(homeList[position]));
                    editor.commit();
                } else {
                    editor.remove(homeList[position]).commit();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeList.length;
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private CheckBox imStar;

        public Holder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.topicId);
            imStar = (CheckBox) itemView.findViewById(R.id.imstar);

        }
    }
}
