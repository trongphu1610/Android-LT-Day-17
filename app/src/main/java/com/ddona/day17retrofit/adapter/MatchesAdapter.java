package com.ddona.day17retrofit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ddona.day17retrofit.R;
import com.ddona.day17retrofit.model.Match;

import net.karthikraj.shapesimage.ShapesImage;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Android on 14/06/2018.
 */

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {
    private List<Match> arrMatches;
    private Context mContext;
    private LayoutInflater inflater;

    public MatchesAdapter(List<Match> arrMatches, Context mContext) {
        this.arrMatches = arrMatches;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_match, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Match matches = arrMatches.get(position);
//        matches.setQuocky2(matches.getQuocky2().replace("https", "http"));
//        matches.setQuocky1(matches.getQuocky1().replace("https", "http"));
        Log.d("doan.pt", matches.getQuocky1() + " " + matches.getQuocky2());
        holder.tvName1.setText(matches.getDoi1());
        holder.tvName2.setText(matches.getDoi2());
        holder.tvKenh.setText(matches.getKenh());
        holder.tvHour.setText(matches.getGio());
        holder.tvDate.setText(matches.getNgay());
        Glide.with(mContext).load(matches.getQuocky1()).placeholder(R.mipmap.ic_launcher).error(R.drawable.error).into(holder.imgDoi1);
        Glide.with(mContext).load(matches.getQuocky2()).placeholder(R.mipmap.ic_launcher).error(R.drawable.error).into(holder.imgDoi2);
    }

    @Override
    public int getItemCount() {
        return arrMatches.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName1, tvName2, tvDate, tvHour, tvKenh;
        ShapesImage imgDoi1, imgDoi2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_ngay);
            tvHour = itemView.findViewById(R.id.tv_gio);
            tvKenh = itemView.findViewById(R.id.tv_kenh);
            tvName1 = itemView.findViewById(R.id.tv_doi1);
            tvName2 = itemView.findViewById(R.id.tv_doi2);
            imgDoi1 = itemView.findViewById(R.id.img_doi1);
            imgDoi2 = itemView.findViewById(R.id.img_doi2);
        }
    }
}
