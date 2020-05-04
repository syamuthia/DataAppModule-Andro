package com.example.komunikasidatajadi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    Button keluar,btnp,btns,btnk,btnm;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        keluar = findViewById(R.id.logout);
        btnp = findViewById(R.id.paralel);
        btns = findViewById(R.id.serial);
        btnk = findViewById(R.id.data);
        btnm = findViewById(R.id.material);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intout = new Intent(Home.this, login_page.class);
                startActivity(intout);
            }
        });


        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intp = new Intent(Home.this, paralel_page.class);
                startActivity(intp);
            }
        });

        btnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intk = new Intent(Home.this, data_page.class);
                startActivity(intk);
            }
        });

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ints = new Intent(Home.this, serial_page.class);
                startActivity(ints);
            }
        });

        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intm = new Intent(Home.this, material_page.class);
                startActivity(intm);
            }
        });
    }
}
