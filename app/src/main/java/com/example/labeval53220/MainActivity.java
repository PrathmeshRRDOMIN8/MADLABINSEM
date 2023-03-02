package com.example.labeval53220;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RadioGroup colorss;
    EditText et;
    String colorchosen = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RADIO GROUP DECLARATION
        colorss =(RadioGroup) findViewById(R.id.colorss);
        Button button=(Button) findViewById(R.id.button) ;
        et = findViewById(R.id.editTextTextPersonName);
//RADIOGROUP LISTENER
        colorss.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.red:
                    {
                        Toast.makeText(MainActivity.this, "Red", Toast.LENGTH_SHORT).show();
                        colorchosen = "red";
                        break;
                    }
                    case R.id.yellow:
                    {
                        Toast.makeText(MainActivity.this, "Yellow", Toast.LENGTH_SHORT).show();
                        colorchosen = "yellow";
                        break;
                    }
                    case R.id.blue:
                    {
                        Toast.makeText(MainActivity.this, "Blue", Toast.LENGTH_SHORT).show();
                        colorchosen = "blue";
                        break;
                    }
                    case R.id.green:
                    {
                        Toast.makeText(MainActivity.this, "Green", Toast.LENGTH_SHORT).show();
                        colorchosen = "green";
                        break;
                    }
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "Name field Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Intent i=new Intent(MainActivity.this,MainActivity2.class);
                    i.putExtra("name", et.getText().toString());
                    i.putExtra("color",colorchosen);
                    startActivity(i);
                }
            }
        });
    }
}