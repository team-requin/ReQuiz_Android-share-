package com.example.requiz;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonObject;

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
        final EditText Signup_Nickname = findViewById(R.id.Signup_Nickname);
        final EditText Signup_ID2 = findViewById(R.id.signup_ID2);
        final EditText Signup_Password = findViewById(R.id.Signup_Password);
        final EditText Signup_pw_confirm = findViewById(R.id.Signup_pw_confirm);
        final Button Nickname_check_button = findViewById(R.id.Nickname_check_button);
        final Button ID_check_button2 = findViewById(R.id.ID_check_button2);
        JsonLoginApi jsonSignUpAp;


        Nickname_check_button.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         String name;
                                                         name = Signup_Nickname.getText().toString();
                                                         RetrofitConnection retrofitConnection = new RetrofitConnection();
                                                         JsonObject jsonObject = new JsonObject();
                                                         jsonObject.addProperty("name", name);

                                                         Call<Void> call = retrofitConnection.sever.checkSameName(jsonObject);
                                                         call.enqueue(new Callback<Void>() {
                                                             @Override
                                                             public void onResponse(Call<Void> call, Response<Void> response) {
                                                                 if (response.code() / 100 == 2) {
                                                                     AlertDialog.Builder builder = new AlertDialog.Builder(Sign_up.this);
                                                                     builder.setMessage("사용가능한 닉네임입니다.")
                                                                             .setPositiveButton("확인", null)
                                                                             .show();
                                                                 }
                                                             }

                                                             @Override
                                                             public void onFailure(Call<Void> call, Throwable t) {

                                                             }
                                                         });
                                                     }
                                                 });


        Signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUserNickname = Signup_Nickname.getText().toString();
                String getId = Signup_ID2.getText().toString();
                String getPw = Signup_Password.getText().toString();
                String getPwChk = Signup_pw_confirm.getText().toString();

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("id",getId);
                jsonObject.addProperty("pw",getPw);
                jsonObject.addProperty("pw_check",getPwChk);
                jsonObject.addProperty("name",getUserNickname);

                RetrofitConnection retrofitConnection = new RetrofitConnection();
                Call<Void> call = retrofitConnection.sever.register(jsonObject);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() / 100 == 2) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Sign_up.this);
                            builder.setMessage("if error" + response.code())
                                    .setNegativeButton("if error", null)
                                    .show();
                            Intent intent = new Intent(Sign_up.this, Login.class);
                            startActivity(intent);
                        }
                        else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(Sign_up.this);
                            builder.setMessage("else error" + response.code())
                                    .setNegativeButton("else error", null)
                                    .show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });

            }
        });
    }
}