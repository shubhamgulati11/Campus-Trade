package com.example.campustrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button go = findViewById(R.id.loginBtn);
        final Intent intent = new Intent(this, Main2Activity.class);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!email.getText().toString().toLowerCase().trim().contains("edu")){
                    Toast.makeText(Main3Activity.this, "Please enter an education email.", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });
    }
}
