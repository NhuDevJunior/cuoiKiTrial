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
import com.example.hancongnhub17dccn481.model.QuanLi_B17DCCN481;

import java.util.List;

public class AdapterCC extends RecyclerView.Adapter<AdapterCC.ViewHolder>{
    private List<QuanLi_B17DCCN481> mCC;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public AdapterCC(List<QuanLi_B17DCCN481> mCC, Context context) {
        this.mCC = mCC;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterCC.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View CCView = inflater.inflate(R.layout.ccitem,parent,false);
        //inflate the custom layout
        ViewHolder viewHolder = new ViewHolder(CCView,  onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        QuanLi_B17DCCN481 cc = mCC.get(position);
        holder.ccInfor.setText(cc.toString());
    }

    @Override
    public int getItemCount() {
        return mCC.size();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener= onItemClickListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        OnItemClickListener onItemClickListener;
        TextView ccInfor;
        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            itemView.setOnClickListener((View.OnClickListener)this);
            ccInfor = itemView.findViewById(R.id.ccinfor);
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}