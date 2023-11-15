package com.example.khamsyherbcsp7c_pm2_exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText edtUser1 = (EditText) findViewById(R.id.edtUserS);
        EditText edtPass1 = (EditText) findViewById(R.id.edtPassS);
        Button btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emp e = new emp();
                e.setUsername(edtUser1.getText().toString());
                e.setPassword(edtPass1.getText().toString());
                Intent b = new Intent(getApplicationContext(),Login.class);
                startActivity(b);
            }
        });
    }
}