package com.example.ebay;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    EditText edt_email,edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        edt_email = findViewById(R.id.edtLoginEmail);
        edt_password = findViewById(R.id.edtloginpassword);
        getSupportActionBar().hide();
        findViewById(R.id.btnlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin(edt_email.getText().toString(),edt_password.getText().toString());
            }
        });
        findViewById(R.id.txtnoregister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignupActivity.class));
            }
        });
    }

    private void checkLogin(final String email, final String password) {

        RequestParams rp =new RequestParams();
        rp.put("email",email);
        rp.put("password",password);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Constants.LOGIN_URL,rp,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    if(response.getString("res").equals("success")){
                        getSharedPreferences("pref",MODE_PRIVATE).edit().putString("email",email).apply();
                        startActivity(new Intent(getApplicationContext(), AllProductsActivity.class)
                                .putExtra("email",email));
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}