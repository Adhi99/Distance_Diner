package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {

    EditText textm2, textm4,textm6;
    Button btn20;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menu");
        //actionBar.setSubtitle("Insert your details to calculate");
        actionBar.setDisplayHomeAsUpEnabled(true);


        textm2 = findViewById(R.id.textm2);
        textm4 = findViewById(R.id.textm4);
        textm6 = findViewById(R.id.textm6);


        btn20 = findViewById(R.id.btn20);

        db = FirebaseDatabase.getInstance().getReference().child("Menus");

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertData();
            }
        });

    }

    private void insertData() {

        String Lunch = textm2.getText().toString();
        String Dinner = textm4.getText().toString();
        String Breakfast = textm6.getText().toString();


      Menus menu= new Menus(Lunch, Dinner, Breakfast);


        db.push().setValue(menu);
        Toast.makeText(MainActivity3.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.checkOut){

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}


