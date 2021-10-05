package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    Button order;
    TextView name_one, quantity_one,price_one,name_two, quantity_two,price_two,name_three, quantity_three,price_three,name_four, quantity_four,price_four;
    TextView text_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        name_one = findViewById(R.id.name_one_one);
        name_two = findViewById(R.id.name_two_two);
        name_three = findViewById(R.id.name_three_three);
        name_four = findViewById(R.id.name_four_four);

        quantity_one = findViewById(R.id.quantity_one_one);
        quantity_two = findViewById(R.id.quantity_two_two);
        quantity_three = findViewById(R.id.quantity_three_three);
        quantity_four = findViewById(R.id.quantity_four_four);

        price_one = findViewById(R.id.price_one_one);
        price_two = findViewById(R.id.price_two_two);
        price_three = findViewById(R.id.price_three_three);
        price_four = findViewById(R.id.price_four_four);

        text_total = findViewById(R.id.total_text);
        order = findViewById(R.id.order_button);

        double price, sub_total;
        int i,burger_quantity=2,grill_quantity=1,pasta_quantity=1,nacho_quantity=1;

        sub_total = 0;

        Intent intent = getIntent();
        String quantity_burger = intent.getStringExtra("burger_quantity");
        String quantity_grill = intent.getStringExtra("grill_quantity");
        String quantity_pasta = intent.getStringExtra("pasta_quantity");
        String quantity_nacho = intent.getStringExtra("nacho_quantity");


        for (i=1; i<=4; i++)
        {
            price = 0;
            if (i==1)
            {
                if(burger_quantity!=0)
                {
                    price = burger_quantity*250;
                    sub_total = sub_total+price;

                    name_one.setText(getString(R.string.burger));
                    quantity_one.setText(String.valueOf(burger_quantity));
                    price_one.setText(String.valueOf(price));
                }
                else if(grill_quantity!=0)
                {
                    price = grill_quantity*110;
                    sub_total += price;

                    name_one.setText(getString(R.string.grill));
                    quantity_one.setText(String.valueOf(grill_quantity));
                    price_one.setText(String.valueOf(price));
                }
                else if(nacho_quantity!=0)
                {
                    price = nacho_quantity*110;
                    sub_total += price;

                    name_one.setText(getString(R.string.nacho));
                    quantity_one.setText(String.valueOf(nacho_quantity));
                    price_one.setText(String.valueOf(price));
                }
                else if(pasta_quantity!=0)
                {
                    price = pasta_quantity*110;
                    sub_total += price;

                    name_one.setText(getString(R.string.pasta));
                    quantity_one.setText(String.valueOf(nacho_quantity));
                    price_one.setText(String.valueOf(price));
                }
                else
                {
                    Toast.makeText(this, "No order Selected.\nError: 102", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            else if(i==2)
            {
                if(grill_quantity!=0)
                {
                    price = grill_quantity*110;
                    sub_total += price;

                    name_two.setText(getString(R.string.grill));
                    quantity_two.setText(String.valueOf(grill_quantity));
                    price_two.setText(String.valueOf(price));
                }
                else if(nacho_quantity!=0)
                {
                    price = nacho_quantity*110;
                    sub_total += price;

                    name_two.setText(getString(R.string.nacho));
                    quantity_two.setText(String.valueOf(nacho_quantity));
                    price_two.setText(String.valueOf(price));
                }
                else if(pasta_quantity!=0)
                {
                    price = pasta_quantity*110;
                    sub_total += price;

                    name_two.setText(getString(R.string.pasta));
                    quantity_two.setText(String.valueOf(pasta_quantity));
                    price_two.setText(String.valueOf(price));
                }
                else
                {
                    break;
                }
            }
            else if (i == 3)
            {
                if(nacho_quantity!=0)
                {
                    price = nacho_quantity*110;
                    sub_total += price;

                    name_three.setText(getString(R.string.nacho));
                    quantity_three.setText(String.valueOf(nacho_quantity));
                    price_three.setText(String.valueOf(price));
                }
                else if(pasta_quantity!=0)
                {
                    price = pasta_quantity*110;
                    sub_total += price;

                    name_three.setText(getString(R.string.pasta));
                    quantity_three.setText(String.valueOf(pasta_quantity));
                    price_three.setText(String.valueOf(price));
                }
                else
                {
                    break;
                }
            }
            else
            {
                if(pasta_quantity!=0)
                {
                    price = pasta_quantity*110;
                    sub_total += price;

                    name_four.setText(getString(R.string.pasta));
                    quantity_four.setText(String.valueOf(pasta_quantity));
                    price_four.setText(String.valueOf(price));
                }
                else
                {
                    break;
                }
            }
        }
        text_total.setText(String.valueOf(sub_total));

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderActivity.this, OrderSuccess_activity.class);
                startActivity(i);
            }
        });
    }
}