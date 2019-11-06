package com.example.medisafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class addMedicine extends AppCompatActivity {
    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        b1= (Button) findViewById(R.id.fab);
        b2= (Button) findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();

            }

        });
    }
    public void openActivity2(){
        Intent intent=new Intent(this,medicineDetails.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,addAppointment.class);
        startActivity(intent);
    }
}
