package com.example.ervin.zalorashope;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText Username, Email , Password, Repassword;
    private Button register;
    private TextView tologin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        Username = (EditText)findViewById(R.id.rgs_username);
        Email = (EditText)findViewById(R.id.rgs_email);
        Password = (EditText)findViewById(R.id.rgs_password);
        Repassword = (EditText)findViewById(R.id.rgs_repassword);
        register =(Button)findViewById(R.id.btn_signup);
        tologin = (TextView)findViewById(R.id.to_Signin);
        firebaseAuth = FirebaseAuth.getInstance();

        // Script untuk menuju halaman login

        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        // Script untuk membuat user baru

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Email.getText().toString().isEmpty() || !Password.getText().toString().isEmpty()){
                    (firebaseAuth.createUserWithEmailAndPassword(Email.getText().toString().trim(), Password.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //menggunakan intent untuk berpindah ke activity login
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                        }
                    });
                }
            }
        });


    }
}
