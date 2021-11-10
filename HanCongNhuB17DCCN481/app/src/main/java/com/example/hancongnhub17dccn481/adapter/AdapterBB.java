package com.example.hancongnhub17dccn481.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hancongnhub17dccn481.R;
import com.example.hancongnhub17dccn481.inter.OnItemClickListener;
import com.example.hancongnhub17dccn481.model.LoaiMon_B17DCCN481;

import java.util.List;

public class AdapterBB extends RecyclerView.Adapter<AdapterBB.ViewHolder>{
    private List<LoaiMon_B17DCCN481> mBB;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public AdapterBB(List<LoaiMon_B17DCCN481> mBB, Context context) {
        this.mBB = mBB;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View BBView = inflater.inflate(R.layout.bbitem,parent,false);
        //inflate the custom layout
        ViewHolder viewHolder = new ViewHolder(BBView,  onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LoaiMon_B17DCCN481 bb = mBB.get(position);
        holder.bbInfor.setText(bb.toString());
    }

    @Override
    public int getItemCount() {
        return mBB.size();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener= onItemClickListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        OnItemClickListener onItemClickListener;
        TextView bbInfor;
        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            itemView.setOnClickListener((View.OnClickListener)this);
            bbInfor = itemView.findViewById(R.id.bbinfor);
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
