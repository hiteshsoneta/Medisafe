package com.example.medisafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class addMedicine extends AppCompatActivity {
    Button b1;
    Button b2;
    Cursor results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        b1= (Button) findViewById(R.id.insertBtn);
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

        Meddb meddb=new Meddb(this);

        results=meddb.getallrecords();

    }
    public void openActivity2(){
        Intent intent=new Intent(this,medicineDetails.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,addAppointment.class);
        startActivity(intent);
    }

    public void gotoInsert(View vw)
    {
        new Meddb(this);
        Intent i=new Intent(this,medicineDetails.class);

        startActivity(i);
    }

    public void display(View vw)
    {
        TextView dispdrug = (TextView) findViewById(R.id.dispdrug);
        TextView disppill = (TextView) findViewById(R.id.disppill);



        if(results.moveToNext())
        {
            dispdrug.setText(results.getString(0));
            disppill.setText((results.getString(1)));
        }
    }
}
