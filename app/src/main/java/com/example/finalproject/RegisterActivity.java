package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    TextView tvDate, etDate;
    DatePickerDialog.OnDateSetListener setListener;
    EditText name, phone,email, password;
    Button register;
    ProgressDialog loadingBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvDate = findViewById(R.id.tv_date);
        etDate = findViewById(R.id.et_date);

        name = findViewById(R.id.name_register_field);
        phone = findViewById(R.id.phone_register_field);
        password = findViewById(R.id.password_register_field);
        email = findViewById(R.id.email_register_field);

        register = findViewById(R.id.registerButton);

        mAuth = FirebaseAuth.getInstance();

        loadingBar = new ProgressDialog(this);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this, android.R.style.Theme_Holo_Light_Dialog, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);
            }
        };


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateAccount();
                loadingBar.setTitle("Creating Account");
                loadingBar.setMessage("Please wait, while we're checking...");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
            }
        });

    }

    private void CreateAccount() {
        String user_name, user_phone, user_password, user_email;

        user_name = name.getText().toString();
        user_phone = phone.getText().toString();
        user_password = password.getText().toString();
        user_email = email.getText().toString();

        if (TextUtils.isEmpty(user_name)){
            Toast.makeText(this, "Name is Required.", Toast.LENGTH_SHORT).show();
            loadingBar.dismiss();
        }
        else if (TextUtils.isEmpty(user_phone)){
            Toast.makeText(this, "Phone Number is Required.", Toast.LENGTH_SHORT).show();
            loadingBar.dismiss();
        }
        else if (TextUtils.isEmpty(user_email)){
            email.setError("Email cannot be empty");
            email.requestFocus();
            loadingBar.dismiss();
        }
        else if (TextUtils.isEmpty(user_password)){
            password.setError("Password cannot be empty");
            password.requestFocus();
            loadingBar.dismiss();
        }
        else if (user_password.length()<6){
            Toast.makeText(this, "Password must have atleast 6 characters.", Toast.LENGTH_SHORT).show();
            loadingBar.dismiss();
        }
        else{

            mAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registered Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        loadingBar.dismiss();

                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "An error occured." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });
        }
        loadingBar.dismiss();
    }
}