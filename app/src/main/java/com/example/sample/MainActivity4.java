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

public class MainActivity4 extends AppCompatActivity {

    EditText et_msg2,editTextTextPersonName,editTextTextPersonName2;
    Button btn30;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Place Order");
        //actionBar.setSubtitle("Insert your details to calculate");
        actionBar.setDisplayHomeAsUpEnabled(true);



        et_msg2 = findViewById(R.id.et_msg22);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);


        btn30 = findViewById(R.id.btn30);

        db = FirebaseDatabase.getInstance().getReference().child("details");

        btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertData();
            }
        });

    }

    private void insertData(){

        String name =  et_msg2.getText().toString();
        String contactNumber= editTextTextPersonName.getText().toString();
        String address = editTextTextPersonName2.getText().toString();


        details detail = new details(name,contactNumber,address);


        db.push().setValue(detail);
        Toast.makeText(MainActivity4.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.edit){

            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);

            return true;

        }
        return super.onOptionsItemSelected(item);
    }


}