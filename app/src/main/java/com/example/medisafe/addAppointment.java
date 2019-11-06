package com.example.medisafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class addAppointment extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener  {

    private static final String TAG="addAppointment";
    TextView a;
    DatePickerDialog.OnDateSetListener d;
    Button b;
    EditText doctor;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        doctor=(EditText)findViewById(R.id.editText7);
        city=(EditText)findViewById(R.id.editText8);
        a=(TextView)findViewById(R.id.textView3);
        Button button=(Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                DialogFragment timePicker =new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");


            }
        });
        a.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(addAppointment.this,d,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();

            }
        });

       d=new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker datePicker, int year, int month, int day) {
               month+=1;
               String date= day+"/"+month+"/"+year;
               a.setText(date);


           }
       };


    }
//press ctrl+o for first time entry.
    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
       //store time in sql
    }
}
