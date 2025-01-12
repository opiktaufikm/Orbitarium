package com.example.projectopik;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

    private final List<Map<String, String>> data;
    private final OnItemClickListener onItemClickListener;

    // Constructor
    public PlanetAdapter(List<Map<String, String>> data, OnItemClickListener onItemClickListener) {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    // Interface for click listener
    public interface OnItemClickListener {
        void onItemClick(Map<String, String> planet);
    }

    @NonNull
    @Override
    public PlanetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.ViewHolder holder, int position) {
        Map<String, String> planet = data.get(position);

        // Set nama planet
        String namaPlanet = planet.get("nama") != null ? planet.get("nama") : "Nama tidak tersedia";
        holder.namaPlanet.setText(namaPlanet);

        // Set image resource
        String imageName = planet.get("img");
        if (imageName != null && !imageName.isEmpty()) {
            int imageResId = holder.itemView.getContext().getResources().getIdentifier(imageName, "drawable", holder.itemView.getContext().getPackageName());
            if (imageResId != 0) {
                holder.imgPlanet.setImageResource(imageResId);
            } else {
                holder.imgPlanet.setImageResource(R.drawable.bumi); // Default image
            }
        } else {
            holder.imgPlanet.setImageResource(R.drawable.bumi); // Default image
        }

        // Handle item click
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(planet);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaPlanet;
        ImageView imgPlanet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaPlanet = itemView.findViewById(R.id.namaPlanet);
            imgPlanet = itemView.findViewById(R.id.imgPlanet);
        }
    }
}
