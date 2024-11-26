package com.example.recyclerviewonandroidgetterandsetter.university;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewonandroidgetterandsetter.R;
import com.example.recyclerviewonandroidgetterandsetter.adapter.UniversityAdapter;

import java.util.ArrayList;
import java.util.List;

public class UniversityPage extends AppCompatActivity {

    private EditText etName, etType, etWebsite;
    private Button btnAddItem;
    private RecyclerView rvUniversities;

    private List<University> universityList;
    private UniversityAdapter universityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.university);

        // Initialize views
        etName = findViewById(R.id.et_name);
        etType = findViewById(R.id.et_type);
        etWebsite = findViewById(R.id.et_website);
        btnAddItem = findViewById(R.id.btn_add_item);
        rvUniversities = findViewById(R.id.rv_university);

        // Initialize data and adapter
        universityList = new ArrayList<>();
        universityAdapter = new UniversityAdapter(universityList);

        // Set up RecyclerView
        rvUniversities.setLayoutManager(new LinearLayoutManager(this));
        rvUniversities.setAdapter(universityAdapter);

        // Button click listener
        btnAddItem.setOnClickListener(v -> addUniversity());
    }

    private void addUniversity() {
        String name = etName.getText().toString();
        String type = etType.getText().toString();
        String website = etWebsite.getText().toString();

        if (!name.isEmpty() && !type.isEmpty() && !website.isEmpty()) {
            // Create new university object and add it to the list
            University university = new University(name, type, website);
            universityList.add(university);

            // Notify the adapter about the new item
            universityAdapter.notifyItemInserted(universityList.size() - 1);

            Log.d("UniversityPage", "Added: " + university.getName());
        }
    }
}
