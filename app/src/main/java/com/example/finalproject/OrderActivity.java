package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {


    TextView textview_no_one, textview_no_two, textview_no_three, textview_no_four,
    textview_name_one, textview_name_two, textview_name_three, textview_name_four,
    textview_quantity_one,textview_quantity_two,textview_quantity_three,textview_quantity_four,
    textview_price_one, textview_price_two, textview_price_three, textview_price_four,
    textview_total_price;

    EditText full_name, contact_number, street_address, city, comment;
    Button go_back, confirm_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        full_name = findViewById(R.id.full_name_address);
        contact_number = findViewById(R.id.contact_number_address);
        street_address = findViewById(R.id.street_address);
        city = findViewById(R.id.city_address);

        go_back = findViewById(R.id.go_back_button);
        confirm_order = findViewById(R.id.order_confirm_button);

        textview_no_one = findViewById(R.id.row_two_textview_one);
        textview_no_two = findViewById(R.id.row_three_textview_one);
        textview_no_three = findViewById(R.id.row_four_textview_one);
        textview_no_four = findViewById(R.id.row_five_textview_one);

        textview_name_one = findViewById(R.id.row_two_textview_two);
        textview_name_two = findViewById(R.id.row_three_textview_two);
        textview_name_three = findViewById(R.id.row_four_textview_two);
        textview_name_four = findViewById(R.id.row_five_textview_two);

        textview_quantity_one = findViewById(R.id.row_two_textview_three);
        textview_quantity_two = findViewById(R.id.row_three_textview_three);
        textview_quantity_three = findViewById(R.id.row_four_textview_three);
        textview_quantity_four = findViewById(R.id.row_five_textview_three);

        textview_price_one = findViewById(R.id.row_two_textview_four);
        textview_price_two = findViewById(R.id.row_three_textview_four);
        textview_price_three = findViewById(R.id.row_four_textview_four);
        textview_price_four = findViewById(R.id.row_five_textview_four);

        textview_total_price = findViewById(R.id.table_two_textview_eight);


        Intent intent = getIntent();
        String quantity = intent.getStringExtra("burger_quantity_key");
        Integer i1 = Integer.parseInt(quantity);

        String quantity2 = intent.getStringExtra("grill_quantity_key");
        Integer i2 = Integer.parseInt(quantity2);

        String quantity3 = intent.getStringExtra("nacho_quantity_key");
        Integer i3 = Integer.parseInt(quantity3);

        String quantity4 = intent.getStringExtra("pasta_quantity_key");
        Integer i4 = Integer.parseInt(quantity4);

        Double sub_total =60.0, price = 0.0;

        if(i1!=0)
        {
            price = i1*250.0;
            sub_total = sub_total+price;

            textview_name_one.setText("Burger");
            textview_quantity_one.setText(String.valueOf(i1));
            textview_price_one.setText(String.valueOf(price));
            price = 0.0;
        }
        if(i2 != 0)
        {
            price = i2*110.0;
            sub_total = sub_total+price;

            textview_name_two.setText("Grill");
            textview_quantity_two.setText(String.valueOf(i2));
            textview_price_two.setText(String.valueOf(price));
            price = 0.0;
        }
        if(i3 != 0)
        {
            price = i3*290.0;
            sub_total = sub_total+price;

            textview_name_three.setText("Nachos");
            textview_quantity_three.setText(String.valueOf(i3));
            textview_price_three.setText(String.valueOf(price));
            price = 0.0;
        }
        if(i4!=0)
        {
            price = i4*180.0;
            sub_total = sub_total+price;

            textview_name_four.setText("Pasta");
            textview_quantity_four.setText(String.valueOf(i4));
            textview_price_four.setText(String.valueOf(price));
            price = 0.0;
        }

        textview_total_price.setText(String.valueOf(sub_total));


        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OrderActivity.this, HomeActivity.class);
                startActivity(intent2);
            }
        });


        confirm_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address_full_name = full_name.getText().toString();
                String address_contact_number = contact_number.getText().toString();
                String address_street = street_address.getText().toString();
                String address_city = city.getText().toString();

                if(!TextUtils.isEmpty(full_name.getText().toString()) && !TextUtils.isEmpty(contact_number.getText().toString()) &&
                        !TextUtils.isEmpty(street_address.getText().toString()) && !TextUtils.isEmpty(city.getText().toString()))
                {
                    /* Have to save order to database */

                    Toast.makeText(OrderActivity.this, "Order Successfully Received.\nThank you for ordering", Toast.LENGTH_SHORT).show();

                    Intent intent3 = new Intent(OrderActivity.this, MainActivity.class);
                    startActivity(intent3);
                }
                else {
                    confirm_order.setError("Address field must be filled");

                    if (TextUtils.isEmpty(full_name.getText().toString()))
                    {
                        full_name.setError("");
                        Toast.makeText(OrderActivity.this, "Full Name must be Filled", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(contact_number.getText().toString()))
                    {
                        contact_number.setError("");
                        Toast.makeText(OrderActivity.this, "Contact Number must be Filled", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(street_address.getText().toString()))
                    {
                        street_address.setError("");
                        Toast.makeText(OrderActivity.this, "Street Address must be Filled", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(city.getText().toString()))
                    {
                        city.setError("");
                        Toast.makeText(OrderActivity.this, "City Name must be Filled", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
