package com.example.misgastosapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.misgastosapp.R;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAdd();
            }
        });

    }

    private void callAdd(){
        Intent intent = new Intent(getApplicationContext(), NewOperationActivity.class);
        startActivity(intent);

    }

}
