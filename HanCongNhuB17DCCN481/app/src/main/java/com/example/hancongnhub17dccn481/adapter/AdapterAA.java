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
import com.example.hancongnhub17dccn481.model.MonAn_B17DCCN481;

import java.util.List;

public class AdapterAA extends RecyclerView.Adapter<AdapterAA.ViewHolder>{
    private List<MonAn_B17DCCN481> mAA;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public AdapterAA(List<MonAn_B17DCCN481> mAA, Context context) {
        this.mAA = mAA;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View AAView = inflater.inflate(R.layout.aaitem,parent,false);
        //inflate the custom layout
        ViewHolder viewHolder = new ViewHolder(AAView,  onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MonAn_B17DCCN481 aa = mAA.get(position);
        holder.aaInfor.setText(aa.toString());
    }

    @Override
    public int getItemCount() {
        return mAA.size();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener= onItemClickListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        OnItemClickListener onItemClickListener;
        TextView aaInfor;
        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            itemView.setOnClickListener((View.OnClickListener)this);
            aaInfor = itemView.findViewById(R.id.aainfor);
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
