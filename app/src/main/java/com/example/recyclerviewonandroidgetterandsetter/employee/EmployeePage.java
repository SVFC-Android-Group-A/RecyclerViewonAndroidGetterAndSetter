package com.example.recyclerviewonandroidgetterandsetter.employee;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewonandroidgetterandsetter.R;
import com.example.recyclerviewonandroidgetterandsetter.adapter.EmployeesAdapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeePage extends AppCompatActivity {

    RecyclerView rvEmployees;
    List<Employee> employeeList = new ArrayList<>();
    EmployeesAdapter employeesAdapter;
    EditText etName, etDepartment, etEmail;
    Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee);

        rvEmployees = findViewById(R.id.rv_employees);
        etName = findViewById(R.id.et_name);
        etDepartment = findViewById(R.id.et_department);
        etEmail = findViewById(R.id.et_email);
        btnAddItem = findViewById(R.id.btn_add_item);

        employeesAdapter = new EmployeesAdapter(employeeList);
        rvEmployees.setAdapter(employeesAdapter);
        rvEmployees.setLayoutManager(new LinearLayoutManager(this));

        btnAddItem.setOnClickListener(v -> addFunction());
    }

    private void addFunction() {
        String name = etName.getText().toString();
        String department = etDepartment.getText().toString();
        String email = etEmail.getText().toString();

        Log.d("EmployeePage", "Name: " + name + ", Department: " + department + ", Email: " + email);

        employeeList.add(new Employee(name, department, email));
        employeesAdapter.notifyItemInserted(employeeList.size() - 1);
    }
}
