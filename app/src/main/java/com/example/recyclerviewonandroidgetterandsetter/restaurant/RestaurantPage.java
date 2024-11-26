package com.example.recyclerviewonandroidgetterandsetter.restaurant;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewonandroidgetterandsetter.R;

import java.util.ArrayList;
import java.util.List;

public class RestaurantPage extends AppCompatActivity {

    EditText etName, etType, etLocation;
    Button btnAddItem;
    RecyclerView rvRestaurants;

    List<Restaurants> restaurantList;
    RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant);

        // Initialize Views
        etName = findViewById(R.id.et_name);
        etType = findViewById(R.id.et_type);
        etLocation = findViewById(R.id.et_location);
        btnAddItem = findViewById(R.id.btn_add_item);
        rvRestaurants = findViewById(R.id.rv_restaurant);

        // Initialize Data
        restaurantList = new ArrayList<>();
        restaurantAdapter = new RestaurantAdapter(restaurantList);

        // Setup RecyclerView
        rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        rvRestaurants.setAdapter(restaurantAdapter);

        // Button Click Listener
        btnAddItem.setOnClickListener(v -> addRestaurant());
    }

    private void addRestaurant() {
        String name = etName.getText().toString();
        String type = etType.getText().toString();
        String location = etLocation.getText().toString();

        if (!name.isEmpty() && !type.isEmpty() && !location.isEmpty()) {
            Restaurants restaurant = new Restaurants(name, type, location);
            restaurantList.add(restaurant);
            restaurantAdapter.notifyItemInserted(restaurantList.size() - 1);

            Log.d("RestaurantPage", "Added: " + restaurant.getName());
        }
    }
}
