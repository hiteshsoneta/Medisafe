package com.example.medisafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText age;
    Button b1;
    public static final String MyPREFERENCES = "MyPrefss" ;
    public static final String Name = "name";
    public static final String Phone = "age";
    public static final String loggedInFlag = "logged_in";

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        checkLoggedIn();

        name = (EditText)findViewById(R.id.name);
        age= (EditText) findViewById(R.id.age);
        b1= (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
                String n  = name.getText().toString();
                String ph  = age.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putBoolean(loggedInFlag, true);

                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
            }

    });

}

    private void checkLoggedIn() {
        boolean loggedIn = sharedpreferences.getBoolean(loggedInFlag, false);
        if (loggedIn) {
            // TODO: GO TO OTHER PAGE
            Intent intent = new Intent(this, addMedicine.class);
            // CLEAR THE STACK SO THAT ON GOING BACK FROM THE NEXT ACTIVITY DOES NOT SHOW THIS PAGE
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            // TODO: DO NOTHING STAY ON THIS PAGE
        }
    }

    public void openActivity2(){
        Intent intent=new Intent(this,addMedicine.class);
        startActivity(intent);
    }
}
