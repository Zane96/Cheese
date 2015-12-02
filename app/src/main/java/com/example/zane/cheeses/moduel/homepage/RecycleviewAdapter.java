package com.example.zane.cheeses.moduel.homepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zane.cheeses.R;
import com.example.zane.cheeses.app.App;
import com.example.zane.cheeses.config.Cheeses;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zane on 15/12/2.
 */
public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyViewHolder>{

    private String[] cheeseName;
    private int imageId;
    public OnItemClickListener listener;

    public interface OnItemClickListener{
           void OnClick(int position);
    }
    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public RecycleviewAdapter(String[] cheeseName){
        this.cheeseName = cheeseName;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(App.getInstance()).inflate(R.layout.item_recycleview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        imageId = Cheeses.getRandomCheeseDrawable();

        Glide.with(App.getInstance())
                .load(imageId)
                .fitCenter()
                .into(holder.imageView);
        holder.textView.setText(cheeseName[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cheeseName.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.cheese_imageview)
        ImageView imageView;
        @Bind(R.id.cheese_textview)
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
