package com.example.ebay;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class ProductDetailsActivity extends AppCompatActivity {

    Product product;
    TextView name, amount, description;
    ImageView image;
    Button buynow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        product = getIntent().getParcelableExtra("product");
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        amount = findViewById(R.id.amount);
        description = findViewById(R.id.description);

        buynow = findViewById(R.id.buynow);
        name.setText(product.getName());
        amount.setText(product.getAmount());
        name.setText(product.getName());
        description.setText(product.getDescription());
        description.setMovementMethod(new ScrollingMovementMethod());


        Glide.with(this).load(product.getImageurl()).into(image);
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlaceOrder(product.getId());
            }
        });
    }

    private void PlaceOrder(String productid) {
        RequestParams user = new RequestParams();
        user.put("email", getSharedPreferences("pref", MODE_PRIVATE).getString("email", ""));
        user.put("productid", productid);

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Constants.PLACE_ODER_URL, user, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(ProductDetailsActivity.this, responseString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Toast.makeText(ProductDetailsActivity.this, responseString, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),OrderPlacedActivity.class));
                finish();
            }
        });
    }
}