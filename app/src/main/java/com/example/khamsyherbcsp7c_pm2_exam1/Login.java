package com.example.khamsyherbcsp7c_pm2_exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_REMEMBER_ME = "rememberMe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edtuser = (EditText) findViewById(R.id.edtUser);
        EditText edtpass = (EditText) findViewById(R.id.edtPass);
        CheckBox rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        TextView link = (TextView) findViewById(R.id.txtlink);
        // link for signup
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),SignUp.class);
                startActivity(a);
            }
        });
        // button login click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check condition username and password
                if(edtuser.getText().toString().trim().equals(emp.Username.trim()) &&
                        edtpass.getText().toString().trim().equals(emp.Password.trim())){
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("username",edtuser.getText().toString());
                    startActivity(i);
                }else{
                    Toast.makeText(Login.this, "ກະລຸນາປ້ອນລະຫັດໃໝ່",Toast.LENGTH_LONG).show();
                }
                String enteredUsername = edtuser.getText().toString().trim();
                String enteredPassword = edtpass.getText().toString().trim();
                if (rememberMe.isChecked()) {
                    saveCredentials(enteredUsername, enteredPassword);
                }
            }
        });

    }
    public void saveCredentials(String username, String password) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.putBoolean(KEY_REMEMBER_ME, true);

        editor.apply();
    }
}