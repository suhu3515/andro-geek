package com.vhd.androgeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText et_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_mobile = findViewById(R.id.et_mob);

        Button btn_mob = findViewById(R.id.btn_mob);
        btn_mob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobile = et_mobile.getText().toString().trim();
                if(mobile.isEmpty() || mobile.length() < 10)
                {
                    et_mobile.setError("Enter a valid mobile...");
                    et_mobile.requestFocus();
                    return;
                }

                Intent otp_intent = new Intent(LoginActivity.this,verifyActivity.class);
                otp_intent.putExtra("mobile",mobile);
                startActivity(otp_intent);
            }
        });
    }
}
