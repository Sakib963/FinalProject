package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText login_email, login_password;
    FirebaseAuth mAuth;
    TextView registerConnector;
    ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login_button);
        login_email = findViewById(R.id.login_email_input);
        login_password = findViewById(R.id.login_password_input);
        mAuth = FirebaseAuth.getInstance();
        registerConnector = findViewById(R.id.register_connect_text);
        loadingBar = new ProgressDialog(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
                loadingBar.setTitle("Logging In");
                loadingBar.setMessage("Please wait, while we're checking...");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
            }
        });
        registerConnector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void LoginUser() {

        String user_password, user_email;
        ;
        user_password = login_password.getText().toString();
        user_email = login_email.getText().toString();

        if (TextUtils.isEmpty(user_email)){
            login_email.setError("Email cannot be empty");
            login_email.requestFocus();
            loadingBar.dismiss();
        }
        else if (TextUtils.isEmpty(user_password)){
            login_password.setError("Password cannot be empty");
            login_password.requestFocus();
            loadingBar.dismiss();
        }
        else{

            mAuth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this, "Logged in Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        loadingBar.dismiss();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Login Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });
        }
        loadingBar.dismiss();
    }
}