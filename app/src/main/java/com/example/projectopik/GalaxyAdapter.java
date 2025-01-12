package com.example.projectopik;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class GalaxyAdapter extends RecyclerView.Adapter<GalaxyAdapter.ViewHolder> {

    private final List<Map<String, String>> data;
    private final OnItemClickListener onItemClickListener;

    public GalaxyAdapter(List<Map<String, String>> data, OnItemClickListener onItemClickListener) {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Map<String, String> d);
    }

    @NonNull
    @Override
    public GalaxyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_galaxy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalaxyAdapter.ViewHolder holder, int position) {
        Map<String, String> galaxy = data.get(position);

        String namaGalaxy = galaxy.get("nama") != null ? galaxy.get("nama") : "Nama tidak tersedia";
        holder.namaGalaxy.setText(namaGalaxy);
        String imageName = galaxy.get("img");
        if (imageName != null && !imageName.isEmpty()) {
            int imageResId = holder.itemView.getContext().getResources().getIdentifier(imageName, "drawable", holder.itemView.getContext().getPackageName());
            if (imageResId != 0) {
                holder.imgGalaxy.setImageResource(imageResId);
            } else {
                holder.imgGalaxy.setImageResource(R.drawable.bimasakti);
            }
        } else {
            holder.imgGalaxy.setImageResource(R.drawable.bimasakti);
        }
        holder.btnLihat.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(data.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaGalaxy;
        ImageView imgGalaxy;
        Button btnLihat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaGalaxy = itemView.findViewById(R.id.namaGalaxy);
            imgGalaxy = itemView.findViewById(R.id.imgGalaxy);
            btnLihat = itemView.findViewById(R.id.btnLihat);
        }
    }
}
