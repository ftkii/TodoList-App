package com.example.myapplicationtodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationtodo.Utils.DBHelper;


public class ActivityLogin extends AppCompatActivity {
    Button btnLogin;
    EditText edusername,edPassword2;
    ImageView backicon2;

    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this,null,null,1);
        edusername = findViewById(R.id.edusername);
        edPassword2 = findViewById(R.id.edPassword2);
        btnLogin = findViewById(R.id.btnLogin);
        backicon2 = findViewById(R.id.backicon2);

        backicon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SgininActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isLoggedId = dbHelper.checkUsername(edusername.getText().toString(),edPassword2.getText().toString());
                if(isLoggedId){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ActivityLogin.this,"Login failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
