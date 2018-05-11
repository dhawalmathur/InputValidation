package com.privateuser.home.inputvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView text_email = null;
    private TextView text_password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // typecasting
        text_email = (TextView) findViewById(R.id.text_email);
        text_password = (TextView) findViewById(R.id.text_password);

        // getting values through intent
        if(getIntent() != null) {
            String email = "Email: " + getIntent().getStringExtra("email");
            String password = "Password: " + getIntent().getStringExtra("password");

            text_email.setText(email);
            text_password.setText(password);
        }
    }
}
