package com.example.recyclerviewonandroidgetterandsetter.products;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewonandroidgetterandsetter.R;
import com.example.recyclerviewonandroidgetterandsetter.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends AppCompatActivity {

    EditText etName, etPrice, etCategory;
    Button btnAddItem;

    RecyclerView rvProduct; // Declare RecyclerView
    ProductAdapter productAdapter;
    List<Product> productList = new ArrayList<>(); // Corrected List<Product>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);  // Ensure this is the correct layout

        etName = findViewById(R.id.et_name);
        etPrice = findViewById(R.id.et_price);
        etCategory = findViewById(R.id.et_category);
        btnAddItem = findViewById(R.id.btn_add_item);
        rvProduct = findViewById(R.id.rv_product); // Bind RecyclerView

        // Initialize adapter and set up RecyclerView
        productAdapter = new ProductAdapter(productList);
        rvProduct.setAdapter(productAdapter);
        rvProduct.setLayoutManager(new LinearLayoutManager(this));

        btnAddItem.setOnClickListener(v -> addFunction());
    }

    private void addFunction() {
        // Ensure input values are valid
        if (etName.getText().toString().isEmpty() || etPrice.getText().toString().isEmpty() || etCategory.getText().toString().isEmpty()) {
            Log.d("MAIN", "Fields cannot be empty!");
            return;
        }

        int price = 0;
        try {
            price = Integer.parseInt(etPrice.getText().toString());
        } catch (NumberFormatException e) {
            Log.d("MAIN", "Invalid price format!");
            return;
        }

        Product product = new Product();
        product.setName(etName.getText().toString());
        product.setPrice(price);
        product.setCategory(etCategory.getText().toString());

        Log.d("MAIN", "name: " + product.getName() + ", price: " + product.getPrice() + ", category: " + product.getCategory());

        productList.add(product); // Add product to the list
        productAdapter.notifyItemInserted(productList.size() - 1); // Notify adapter
    }
}
