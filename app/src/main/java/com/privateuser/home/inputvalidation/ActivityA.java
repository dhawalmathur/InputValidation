package com.privateuser.home.inputvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends AppCompatActivity {

    private EditText et_email = null;
    private EditText et_password = null;
    private Button btn_A = null;
    private Intent intentA = null;
    private String email = "", password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // typecasting
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_A = (Button) findViewById(R.id.btn_A);
        intentA = new Intent(ActivityA.this, ActivityB.class);

        // click listener
        btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailIsValid()) {
                    intentA.putExtra("email", email);
                    intentA.putExtra("password", password);
                    startActivity(intentA);
                }
            }
        });
    }

    private boolean emailIsValid() {
        email = et_email.getText().toString().trim();
        password = et_password.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            et_email.setError(getString(R.string.err_emptyEmail));
            et_email.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError(getString(R.string.err_invalidEmail));
            et_email.requestFocus();
            return false;
        } else if(TextUtils.isEmpty(password)) {
            et_password.setError(getString(R.string.err_emptyPassword));
            et_password.requestFocus();
            return false;
        } else if(password.length() < 8) {
            et_password.setError(getString(R.string.err_shortPassword));
            et_password.requestFocus();
            return false;
        }
        return true;
    }
}
