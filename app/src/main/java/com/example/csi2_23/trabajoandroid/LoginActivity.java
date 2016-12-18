package com.example.csi2_23.trabajoandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private EditText edtUsername, edtPassword;
    private CheckBox chkLogin;
    private Switch switchShow;
    private Button btnLogin;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        chkLogin = (CheckBox) findViewById(R.id.chkLogin);
        switchShow = (Switch) findViewById(R.id.switchShow);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        switchShow.setOnCheckedChangeListener(this);

        sp = getSharedPreferences("data", MODE_PRIVATE);
        if (sp.contains("user")) {
            edtUsername.setText(sp.getString("user", ""));
            edtPassword.setText(sp.getString("password", ""));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:

                if (chkLogin.isChecked()){

                    if (edtUsername.getText().length() != 0 && edtPassword.getText().length() != 0) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("user", edtUsername.getText().toString());
                        editor.putString("password", edtPassword.getText().toString());
                        editor.commit();

                        Intent i = new Intent(LoginActivity.this, ListActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(this, R.string.alertFillUserAndPassword, Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, R.string.errorLoginTerms, Toast.LENGTH_SHORT).show();
                    chkLogin.setTextColor(Color.RED);
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch(compoundButton.getId()){
            case R.id.switchShow:

                if (switchShow.isChecked()) {
                    edtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                edtPassword.setSelection(edtPassword.length());

                break;
        }
    }
}
