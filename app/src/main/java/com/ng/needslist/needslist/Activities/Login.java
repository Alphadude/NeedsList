package com.ng.needslist.needslist.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.ProfileTracker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ng.needslist.needslist.Modal.AuthenticationData;
import com.ng.needslist.needslist.Modal.Response;
import com.ng.needslist.needslist.R;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.subscriptions.CompositeSubscription;


public class Login extends AppCompatActivity {

   private CompositeSubscription mSubscriptions;


    ImageButton googleButton;
    Button Login;

    // global variables for facebook login
    CallbackManager callbackManager;
    private AccessTokenTracker mAccessTokenTracker;
    private ProfileTracker mProfileTracker;
    private String mToken;



    private EditText mEmail, mPassword;
    private TextInputLayout tilEmail, tilPassword;
    private ProgressDialog dialog;

    //FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSubscriptions = new CompositeSubscription();

        mEmail = (EditText)findViewById(R.id.et_usernameLogin);
        mPassword = (EditText)findViewById(R.id.etPasswordLogin);
        tilEmail = (TextInputLayout)findViewById(R.id.tilEmailLogin);
        tilPassword = (TextInputLayout)findViewById(R.id.tilPasswordLogin);
        //mAuth = FirebaseAuth.getInstance();



        TextView register = (TextView) findViewById(R.id.signup);
        TextView forgottenPassword = (TextView)findViewById(R.id.forgetPassword);

        googleButton = (ImageButton) findViewById(R.id.googleBtn);
        Login = (Button) findViewById(R.id.btnLogin) ;


        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               //loginProcess();
                login();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent signup = new Intent(Login.this, Register.class);
                startActivity(signup);


            }
        });



        forgottenPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent forgotenPass = new Intent(Login.this, ForgottenPassword.class);
                startActivity(forgotenPass);

            }
        });
    }
    public void login(){
        Intent move = new Intent(Login.this,Feeds.class);
        startActivity(move);
    }


    private void showToastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }



    private void handleResponse(Response response) {
        switch (response.getStatus_code()) {
            case 200:
                AuthenticationData userInfo = (AuthenticationData) response.getData();
                showToastMessage("Welcome " + userInfo.getFirst_name());


                break;

            case 400:
                //request doesn't make sense to server, maybe a parameter is missing
                showMessage(response.getError());
                break;

            case 401:
                //unauthorised request, need to provide a valid token
                showMessage(response.getError());
                break;

            case 500:
                //this is purely a server problem
                showToastMessage(response.getError());
                break;
        }


    }

    private void handleError(Throwable throwable) {

        if (throwable instanceof HttpException) {
            Gson gson = new GsonBuilder().create();

            try {
                String errorBody = ((HttpException) throwable).response().errorBody().string();
                Response response = gson.fromJson(errorBody, Response.class);
                showMessage(response.getError());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (throwable instanceof IOException) {
            // if it is not a server error show a toast that it is a network error
            showMessage("Please check your internet connection");
        } else {
            showMessage("What happened?");
        }

    }

    private void showMessage(String s) {
        Toast.makeText(Login.this, s, Toast.LENGTH_SHORT).show();
    }

    private void setError() {

        tilEmail.setError(null);
        tilPassword.setError(null);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //FirebaseUser user = mAuth.getCurrentUser();

//        if (user != null) {
//            Toast.makeText(this, "Welcome " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
//        }

    }



}

