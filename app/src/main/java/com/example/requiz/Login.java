package com.example.requiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textView = findViewById(R.id.sign_up_text);
        textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Intent intent= new Intent(Login.this, Sign_up.class);
                    startActivity(intent);
                }
            }
        );
    }
}
