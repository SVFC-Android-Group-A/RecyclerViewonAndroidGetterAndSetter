package com.example.recyclerviewonandroidgetterandsetter.restaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewonandroidgetterandsetter.R;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private List<Restaurants> restaurantList;

    public RestaurantAdapter(List<Restaurants> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant_card, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurants restaurant = restaurantList.get(position);
        holder.tvName.setText(restaurant.getName());
        holder.tvType.setText(restaurant.getType());
        holder.tvLocation.setText(restaurant.getLocation());
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvType, tvLocation;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_name);
            tvType = itemView.findViewById(R.id.txt_type);
            tvLocation = itemView.findViewById(R.id.txt_location);
        }
    }
}
