package com.example.myapplicationtodo.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationtodo.ActivityLogin;
import com.example.myapplicationtodo.R;
import com.example.myapplicationtodo.Utils.DBHelper;

public class Register extends AppCompatActivity {
        EditText editTextuser,editTextPassword,retypePassword;
        Button btnRegister,btnGoLogin;
        DBHelper dbHelper;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextuser = findViewById(R.id.editTextuser);
        editTextPassword =findViewById(R.id.editTextPassword);
        retypePassword = findViewById(R.id.retypePassword);
        btnRegister =findViewById(R.id.btnRegister);
        btnGoLogin = findViewById(R.id.btnGoLogin);
        dbHelper = new DBHelper(this,null,null,1);


        btnGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user,pwd,rtw;
                user = editTextuser.getText().toString();
                pwd = editTextPassword.getText().toString();
                rtw = retypePassword.getText().toString();

                if (user.equals("") || pwd.equals("") || rtw.equals("")){
                    Toast.makeText(Register.this,"please fill all the field",Toast.LENGTH_SHORT).show();

                }else {
                    if(pwd.equals(rtw)){
                        if(dbHelper.checkUser(user)){
                            Toast.makeText(Register.this,"user already exists",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //proceed with reg
                       boolean registerSuccess = dbHelper.insertData(user,pwd);
                       if(registerSuccess)
                           Toast.makeText(Register.this,"Register Success",Toast.LENGTH_SHORT).show();
                       else {
                           Toast.makeText(Register.this,"Register Failed",Toast.LENGTH_SHORT).show();
                       }
                    }
                    else {
                        Toast.makeText(Register.this,"password do not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
