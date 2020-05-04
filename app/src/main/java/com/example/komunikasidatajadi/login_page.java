package com.example.komunikasidatajadi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_page extends AppCompatActivity {

    EditText emailid, password;
    Button btnlogin;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.usernameformlogin);
        password = findViewById(R.id.passwordformlogin);
        btnlogin = findViewById(R.id.loginbutton);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(login_page.this, "You are Logged in", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(login_page.this, Home.class);
                    startActivity(i);
                } else {
                    Toast.makeText(login_page.this, "Please Login", Toast.LENGTH_LONG).show();
                }
            }
        };
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = emailid.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailid.setError("Please enter email acount");
                    emailid.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter the password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(login_page.this, "Fields are Empty!", Toast.LENGTH_LONG).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(login_page.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(login_page.this, "Login Error, Please Try Again!", Toast.LENGTH_LONG).show();
                            } else {
                                Intent intHomte = new Intent(login_page.this, Home.class);
                                startActivity(intHomte);
                            }
                        }
                    });
                } else {
                    Toast.makeText(login_page.this, "Error Ocured!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
        @Override
        protected void onStart(){
            super.onStart();
            mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intb = new Intent(login_page.this,MainActivity.class);
        startActivity(intb);
    }
}

