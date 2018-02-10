package com.ng.needslist.needslist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ng.needslist.needslist.R;


public class Register extends AppCompatActivity {

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView loginTextView = (TextView) findViewById(R.id.login);
        register = (Button) findViewById(R.id.buttonRegister);

        loginTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent signin = new Intent(Register.this, Login.class);
                startActivity(signin);

            }
        });
    }

}
