package com.example.requiz;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Button Signup_button = findViewById(R.id.Signup_button);
        Signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetrofitConnection retrofitConnection = new RetrofitConnection();
//                Call<List<LoginPost>> call = retrofitConnection.sever.getPost();
                /*call.enqueue(new Callback<List<LoginPost>>() {
                    @Override
                    public void onResponse(Call<List<LoginPost>> call, Response<List<LoginPost>> response) {
                        if (response.code() == 201) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Sign_up.this);
                            builder.setMessage("if error" + response.code())
                                    .setNegativeButton("if error", null)
                                    .show();
//                                Intent intent = new Intent(Login.this, Sign_up.class);
//                                startActivity(intent);

                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Sign_up.this);
                            builder.setMessage("else error" + response.code())
                                    .setNegativeButton("else error", null)
                                    .show();
//                                Intent intent = new Intent(Login.this, MainActivity.class);
//                                startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<LoginPost>> call, Throwable t) {

                    }
                });*/

//                Intent intent = new Intent(Sign_up.this, MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}
