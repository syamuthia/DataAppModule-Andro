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

public class signup_page extends AppCompatActivity {
    EditText usernamereg,passwordreg,acountemail;
    Button signupbutton;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        mFirebaseAuth = FirebaseAuth.getInstance();
        acountemail = findViewById(R.id.email);
        usernamereg = findViewById(R.id.usernamesignupform);
        passwordreg = findViewById(R.id.passwordsignupform);
        signupbutton = findViewById(R.id.signupbutton);

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = acountemail.getText().toString();
                String pwd = passwordreg.getText().toString();
                String user = usernamereg.getText().toString();
                if(email.isEmpty()){
                    acountemail.setError("Please enter email acount");
                    acountemail.requestFocus();
                }
                else if (pwd.isEmpty()){
                    passwordreg.setError("Please enter the password");
                    passwordreg.requestFocus();
                }
                else if(user.isEmpty()){
                    usernamereg.setError("Please enter username");
                    usernamereg.requestFocus();
                }
                else if(user.isEmpty() && pwd.isEmpty() && email.isEmpty()){
                    Toast.makeText(signup_page.this,"Fields are Empty!",Toast.LENGTH_LONG).show();
                }

                else if(!(user.isEmpty() && pwd.isEmpty() && email.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(signup_page.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(signup_page.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_LONG).show();
                            }
                            else {
                                startActivity(new Intent(signup_page.this,Home.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(signup_page.this,"Error Ocured!",Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intb = new Intent(signup_page.this,MainActivity.class);
        startActivity(intb);
    }
}
