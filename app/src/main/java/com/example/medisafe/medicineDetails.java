package com.example.medisafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.view.TextureView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class medicineDetails extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    EditText ed1;
    EditText ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);

        ed1 =(EditText)findViewById(R.id.editText2);
        ed2 =(EditText)findViewById(R.id.editText3);

        Button button=(Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                DialogFragment timePicker =new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");


            }
        });
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

        Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR,i);
        intent.putExtra(AlarmClock.EXTRA_MINUTES,i1);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,"drug:" + ed1.getText() + " no of pills" + ed2.getText());
        startActivity(intent);

    }

}
