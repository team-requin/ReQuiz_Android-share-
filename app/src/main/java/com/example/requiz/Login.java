package com.example.requiz;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final JsonLoginApi jsonPlaceHolderApi;
        Button registerButton = findViewById(R.id.login_button);
        TextView textView = findViewById(R.id.sign_up_text);
        final EditText id = findViewById(R.id.input_id);
        final EditText pw = findViewById(R.id.input_password);
        registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){

                    String getId = id.getText().toString();
                    String getPw = pw.getText().toString();

//                    jsonPlaceHolderApi = RetrofitConnection

                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("id", getId);
                    jsonObject.addProperty("pw", getPw);
//                    jsonPlaceHolderApi.jsonPlaceHolderApi(jsonObject);
                    RetrofitConnection retrofitConnection = new RetrofitConnection();
                    Call<Token> call = retrofitConnection.sever.login(jsonObject);
                    call.enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(Call<Token> call, Response<Token> response) {
                            if (response.code() / 100 == 2) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setMessage("if error" + response.code())
                                        .setNegativeButton("if error", null)
                                        .show();
                                Intent intent = new Intent(Login.this, Sign_up.class);
                                startActivity(intent);
    
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setMessage("else error" + response.code())
                                        .setNegativeButton("else error", null)
                                        .show();
//                                Intent intent = new Intent(Login.this, MainActivity.class);
//                                startActivity(intent);
                            }

                        }

                        @Override
                            public void onFailure(Call<Token> call, Throwable t) {

                        }
                    });

                }
            }
        );
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Sign_up.class);
                startActivity(intent);
            }
        });
    }
}
