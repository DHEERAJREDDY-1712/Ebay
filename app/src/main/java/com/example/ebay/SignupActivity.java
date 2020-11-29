package com.example.ebay;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class SignupActivity extends AppCompatActivity {

    EditText fname,lname,email,password,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        fname = findViewById(R.id.edtfirstname);
        lname = findViewById(R.id.edtlastname);
        email = findViewById(R.id.edtLoginEmail);
        password = findViewById(R.id.edtloginpassword);
        address = findViewById(R.id.address);
        findViewById(R.id.btnlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup(Constants.SIGNUP_URL,fname.getText().toString(),lname.getText().toString(),email.getText().toString(),password.getText().toString(),address.getText().toString());
            }
        });
    }

    private void signup(String url,String firstname, String lastname, String email, String password, String address) {
        RequestParams rp = new RequestParams();
        rp.put("firstname", firstname);
        rp.put("lastname", lastname);
        rp.put("email", email);
        rp.put("password", password);
        rp.put("address", address);

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(url,rp,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    if(response.getString("res").equals("success")){
                        finish();

                    }
                    Toast.makeText(SignupActivity.this, response.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(SignupActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}