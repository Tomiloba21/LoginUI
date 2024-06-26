package com.example.judepast.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.judepast.Domain.TrendsDomain;
import com.example.judepast.R;

import java.util.ArrayList;

public class TrendsAdapter extends RecyclerView.Adapter<TrendsAdapter.Viewholder> {


    ArrayList<TrendsDomain> items ;

    Context context;

    public TrendsAdapter(ArrayList<TrendsDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public TrendsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflator  = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder,parent,false);
        context = parent.getContext();
        return new Viewholder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendsAdapter.Viewholder holder, int position) {
        holder.title.setText(items.get(position).getTitle());

        holder.subtitle.setText(items.get(position).getSubtitle());

        int drawableResourseId = holder.itemView.getResources().getIdentifier(items.get(position).getPicAddress(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                    .load(drawableResourseId)
                    .transform(new GranularRoundedCorners(30,30,0,0))
                    .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView title,subtitle;
        ImageView pic;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleTxt);
            subtitle = itemView.findViewById(R.id.subtitleTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
