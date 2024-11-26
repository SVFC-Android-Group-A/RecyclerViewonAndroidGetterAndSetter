package com.example.recyclerviewonandroidgetterandsetter.books;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewonandroidgetterandsetter.adapter.BooksAdapter;
import com.example.recyclerviewonandroidgetterandsetter.R;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends AppCompatActivity {

    // Fixed the errors
    RecyclerView rvBook;
    List<Books> bookList = new ArrayList<>();
    BooksAdapter booksAdapter;

    EditText etTitle, etAuthor, etGenre;
    Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books);

        // Initialize views
        rvBook = findViewById(R.id.rv_book);
        etTitle = findViewById(R.id.et_title);
        etAuthor = findViewById(R.id.et_author);
        etGenre = findViewById(R.id.et_genre);
        btnAddItem = findViewById(R.id.btn_add_item);

        // Set up RecyclerView and adapter
        booksAdapter = new BooksAdapter(bookList);
        rvBook.setAdapter(booksAdapter);
        rvBook.setLayoutManager(new LinearLayoutManager(this));

        // Add button listener
        btnAddItem.setOnClickListener(v -> addFunction());
    }

    private void addFunction() {
        // Validate inputs
        if (etTitle.getText().toString().isEmpty() ||
                etAuthor.getText().toString().isEmpty() ||
                etGenre.getText().toString().isEmpty()) {
            Log.d("MAIN", "All fields are required!");
            return;
        }

        // Create new book object
        Books book = new Books(
                etTitle.getText().toString(),
                etAuthor.getText().toString(),
                etGenre.getText().toString()
        );

        // Add book to list and notify adapter
        bookList.add(book);
        booksAdapter.notifyItemInserted(bookList.size() - 1);

        Log.d("MAIN", "Added book: " + book.getTitle() + " by " + book.getAuthor());
    }
}
