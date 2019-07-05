package com.example.requiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_button = findViewById(R.id.search_button);
//        login_button.setClickable(true); 클릭가능하게 만듬
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Quiz_list_owner.class);
                startActivity(intent);
            }
        });
        TextView textView= findViewById(R.id.login_button);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
