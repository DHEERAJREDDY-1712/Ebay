package com.example.ebay;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class AllProductsActivity extends AppCompatActivity {

    String userEmail;

    RecyclerView list;
    ArrayList<Product> arrayList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        userEmail = getIntent().getExtras().getString("email");
        list = findViewById(R.id.list);
        list.setLayoutManager(new GridLayoutManager(getApplicationContext(),3,RecyclerView.VERTICAL,false));
        list.setAdapter(new ProductAdapter(this,arrayList));

        getProducts();

    }

    private void getProducts() {

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Constants.PRODUCTS_URL,new RequestParams(),new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    if(response.getString("res").equals("success")){
                        JSONArray ja =response.getJSONArray("data");
                        for(int i =0 ;i<ja.length();i++){
                            JSONObject jo = ja.getJSONObject(i);
                            Product product = new Product();
                            product.setId(jo.getString("id"));
                            product.setName(jo.getString("name"));
                            product.setAmount(jo.getString("price"));
                            product.setImageurl(jo.getString("imageurl"));
                            product.setDescription(jo.getString("description"));
                            arrayList.add(product);
                        }
                       
                        list.getAdapter().notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}