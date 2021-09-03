package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HomeActivity extends AppCompatActivity {
    ImageView burger, grill, pasta, nacho;
    FloatingActionButton floatingActionButton;
    Button burger_cart, burger_plus, burger_minus, grill_cart, grill_plus, grill_minus, pasta_cart, pasta_plus, pasta_minus, nacho_cart, nacho_plus, nacho_minus;
    TextView burger_quantity,grill_quantity, pasta_quantity,nacho_quantity;
    int quantity_of_burger,quantity_of_grill, quantity_of_pasta,quantity_of_nacho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        burger = findViewById(R.id.burger_image);
        burger_cart = findViewById(R.id.burger_cart_button);
        burger_plus = findViewById(R.id.plus_burger);
        burger_minus = findViewById(R.id.minus_burger);
        burger_quantity = findViewById(R.id.burger_quantity_text);


        grill = findViewById(R.id.grill_image);
        grill_cart = findViewById(R.id.grill_cart_button);
        grill_plus = findViewById(R.id.plus_grill);
        grill_minus = findViewById(R.id.minus_grill);
        grill_quantity = findViewById(R.id.grill_quantity_text);

        pasta = findViewById(R.id.pasta_image);
        pasta_cart = findViewById(R.id.pasta_cart_button);
        pasta_plus = findViewById(R.id.plus_pasta);
        pasta_minus = findViewById(R.id.minus_pasta);
        pasta_quantity = findViewById(R.id.pasta_quantity_text);

        nacho = findViewById(R.id.nachos_image);
        nacho_cart = findViewById(R.id.nacho_cart_button);
        nacho_plus = findViewById(R.id.plus_nacho);
        nacho_minus = findViewById(R.id.minus_nacho);
        nacho_quantity = findViewById(R.id.nacho_quantity_text);

        floatingActionButton = findViewById(R.id.floating_button);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ChatActivity.class));
            }
        });

        burger_quantity.setVisibility(View.INVISIBLE);
        burger_minus.setVisibility(View.INVISIBLE);
        burger_plus.setVisibility(View.INVISIBLE);

        grill_quantity.setVisibility(View.INVISIBLE);
        grill_minus.setVisibility(View.INVISIBLE);
        grill_plus.setVisibility(View.INVISIBLE);

        pasta_quantity.setVisibility(View.INVISIBLE);
        pasta_minus.setVisibility(View.INVISIBLE);
        pasta_plus.setVisibility(View.INVISIBLE);

        nacho_quantity.setVisibility(View.INVISIBLE);
        nacho_minus.setVisibility(View.INVISIBLE);
        nacho_plus.setVisibility(View.INVISIBLE);

        quantity_of_burger = 1;
        quantity_of_grill = 1;
        quantity_of_pasta = 1;
        quantity_of_nacho = 1;



        burger_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                burger_cart.setVisibility(View.INVISIBLE);

                burger_minus.setVisibility(View.VISIBLE);
                burger_plus.setVisibility(View.VISIBLE);
                burger_quantity.setVisibility(View.VISIBLE);
            }
        });

        burger_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_of_burger = quantity_of_burger -1;

                burger_quantity.setText(String.valueOf(quantity_of_burger));
            }
        });

        burger_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_of_burger = quantity_of_burger + 1;

                burger_quantity.setText(String.valueOf(quantity_of_burger));
            }
        });

        grill_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grill_cart.setVisibility(View.INVISIBLE);

                grill_minus.setVisibility(View.VISIBLE);
                grill_plus.setVisibility(View.VISIBLE);
                grill_quantity.setVisibility(View.VISIBLE);
            }
        });

        grill_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_of_grill = quantity_of_grill -1;

                grill_quantity.setText(String.valueOf(quantity_of_grill));
            }
        });

        grill_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_of_grill = quantity_of_grill + 1;

                grill_quantity.setText(String.valueOf(quantity_of_grill));
            }
        });

        pasta_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasta_cart.setVisibility(View.INVISIBLE);

                pasta_minus.setVisibility(View.VISIBLE);
                pasta_plus.setVisibility(View.VISIBLE);
                pasta_quantity.setVisibility(View.VISIBLE);
            }
        });

        pasta_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_of_pasta = quantity_of_pasta -1;

                pasta_quantity.setText(String.valueOf(quantity_of_pasta));
            }
        });

        pasta_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_of_pasta = quantity_of_pasta + 1;

                pasta_quantity.setText(String.valueOf(quantity_of_pasta));
            }
        });

        nacho_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nacho_cart.setVisibility(View.INVISIBLE);

                nacho_minus.setVisibility(View.VISIBLE);
                nacho_plus.setVisibility(View.VISIBLE);
                nacho_quantity.setVisibility(View.VISIBLE);
            }
        });

        nacho_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_of_nacho = quantity_of_nacho -1;

                nacho_quantity.setText(String.valueOf(quantity_of_nacho));
            }
        });

        nacho_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_of_nacho = quantity_of_nacho + 1;

                nacho_quantity.setText(String.valueOf(quantity_of_nacho));
            }
        });

    }
}