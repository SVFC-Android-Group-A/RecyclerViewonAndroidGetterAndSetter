package com.example.recyclerviewonandroidgetterandsetter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewonandroidgetterandsetter.books.BooksPage;
import com.example.recyclerviewonandroidgetterandsetter.employee.EmployeePage;
import com.example.recyclerviewonandroidgetterandsetter.products.ProductsPage;
import com.example.recyclerviewonandroidgetterandsetter.restaurant.RestaurantPage;
import com.example.recyclerviewonandroidgetterandsetter.university.UniversityPage;

public class MainActivity extends AppCompatActivity {

    Button btnBooksPage, btnEmployeePage, btnProductsPage, btnRestaurantPage, btnUniversityPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure the layout file matches

        // Initialize buttons
        btnProductsPage = findViewById(R.id.btn_products_page);
        btnBooksPage = findViewById(R.id.btn_book_page);
        btnEmployeePage = findViewById(R.id.btn_employee_page);
        btnRestaurantPage = findViewById(R.id.btn_restaurant_page);
        btnUniversityPage = findViewById(R.id.btn_university_page);

        // Set button click listeners
        btnProductsPage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductsPage.class); // Correct class name
            startActivity(intent);
        });

        btnBooksPage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BooksPage.class);
            startActivity(intent);
        });

        btnEmployeePage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EmployeePage.class);
            startActivity(intent);
        });

        btnRestaurantPage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RestaurantPage.class);
            startActivity(intent);
        });

        btnUniversityPage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UniversityPage.class);
            startActivity(intent);
        });
    }
}
