package com.patipatphiphi.mydemoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final String mailuser = "admin@gmail.com";
    private final String passworduser = "1234";
    @BindView(R.id.bg_login) ImageView bgLogin;
    @BindView(R.id.titile_app) TextView titileApp;
    @BindView(R.id.email) TextView email;
    @BindView(R.id.et_mail) EditText etMail;
    @BindView(R.id.email_layout) LinearLayout emailLayout;
    @BindView(R.id.password) TextView password;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.password_layout) LinearLayout passwordLayout;
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.btn_signup) Button btnSignup;
    @BindView(R.id.btn_layout) LinearLayout btnLayout;
    @BindView(R.id.noti_message) TextView notiMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(onLoginClickListener);
        btnSignup.setOnClickListener(onSignUpClickListener);
        
    }

    private boolean checkUser(String id, String pass) {
        if (mailuser.equals(id) && passworduser.equals(pass)) {
            return true;
        } else {
            return false;
        }
    }

    private View.OnClickListener onSignUpClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            navigateToSignUp();
        }
    };
    private View.OnClickListener onLoginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (etMail.getText().toString().contains("@gmail.com")) {
                boolean statusLogin = checkUser(etMail.getText().toString(), etPassword.getText().toString());
                if (statusLogin) {
                    navigateToPage2();
                } else {
                    navigateToSignUp();
                }
            } else {
                notiMessage.setText("Pleas input Gmail");
            }
        }
    };

    private void navigateToSignUp() {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        intent.putExtra("mailRegister", etMail.getText().toString());
        startActivity(intent);
        finish();
    }

    private void navigateToPage2() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }


}
