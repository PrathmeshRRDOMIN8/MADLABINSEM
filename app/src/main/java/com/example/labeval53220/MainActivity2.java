package com.example.labeval53220;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txtView = (TextView) findViewById(R.id.textView);
        TextView txtView2 = (TextView) findViewById(R.id.textView2);
        txtView.setText(getIntent().getStringExtra("name").replaceAll("(?i)[^aeiou]", ""));
        txtView2.setText(getIntent().getStringExtra("name").replaceAll("(?i)[aeiou]", ""));
        txtView2.setTextColor(Color.BLACK);
        String colorchosen = getIntent().getStringExtra("color");
        if (colorchosen.toString().matches("red")) txtView.setTextColor(Color.RED);
        if (colorchosen.toString().matches("yellow")) txtView.setTextColor(Color.YELLOW);
        if (colorchosen.toString().matches("blue")) txtView.setTextColor(Color.BLUE);
        if (colorchosen.toString().matches("green")) txtView.setTextColor(Color.GREEN);
    }
    @Override
    public void onBackPressed() {
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);

        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ?");

        // Set Alert Title
        builder.setTitle("Alert !");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            // When the user click yes button then app will close
            finish();
        });

        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
}
