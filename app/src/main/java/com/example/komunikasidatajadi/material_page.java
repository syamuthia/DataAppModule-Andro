package com.example.komunikasidatajadi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class material_page extends AppCompatActivity {
    Button modul,jobsit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_page);
        modul = findViewById(R.id.module);
        jobsit = findViewById(R.id.jobsheet);

        modul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(android.content.Intent.ACTION_VIEW); webIntent.setData(Uri.parse("https://facebook.com"));
                startActivity(webIntent);
            }
        });

        jobsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(android.content.Intent.ACTION_VIEW); webIntent.setData(Uri.parse("https://facebook.com"));
                startActivity(webIntent);
            }
        });

    }
}