package com.patipatphiphi.mydemoapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by patipat_phi on 6/13/2017 AD.
 */

public class SignUpActivity extends AppCompatActivity {
    private EditText name;
    private EditText surname;
    private EditText mail;
    private EditText tel;
    private Button sigup;
    private String mailForRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        getValue();
        initView();
        setView();
    }

    private void setView() {
        mail.setText(mailForRegister);
    }

    private void getValue() {
        mailForRegister = getIntent().getStringExtra("mailRegister");
    }

    private void initView() {
        name = (EditText) findViewById(R.id.et_name);
        surname = (EditText) findViewById(R.id.et_surname);
        mail = (EditText) findViewById(R.id.et_mail);
        tel = (EditText) findViewById(R.id.et_tel);
        sigup = (Button) findViewById(R.id.btn_signup);
    }
}
