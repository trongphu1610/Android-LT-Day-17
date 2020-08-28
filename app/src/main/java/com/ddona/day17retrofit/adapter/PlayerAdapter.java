package com.ddona.day17retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ddona.day17retrofit.R;
import com.ddona.day17retrofit.model.Player;

import net.karthikraj.shapesimage.ShapesImage;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Android on 14/06/2018.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    private List<Player> arrPlayers;
    private Context mContext;

    public PlayerAdapter(List<Player> arrPlayers, Context mContext) {
        this.arrPlayers = arrPlayers;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_player, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Player player = arrPlayers.get(position);
        holder.tvTen.setText(player.getTen());
        holder.tvSocial.setText("Click to view");
        holder.tvDoi.setText(player.getDoi());
        Glide.with(mContext).load(player.getImage()).placeholder(R.mipmap.ic_launcher).error(R.drawable.error).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrPlayers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTen, tvDoi, tvSocial;
        ShapesImage image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTen = itemView.findViewById(R.id.tv_name_cau_thu);
            tvSocial = itemView.findViewById(R.id.tv_view_social);
            tvDoi = itemView.findViewById(R.id.tv_doi_cau_thu);
            image = itemView.findViewById(R.id.img_image_cau_thu);
        }
    }
}
