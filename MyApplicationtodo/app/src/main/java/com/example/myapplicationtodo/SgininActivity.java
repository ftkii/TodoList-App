package com.example.myapplicationtodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.myapplicationtodo.Model.Register;

public class SgininActivity extends AppCompatActivity {

ImageView backimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        backimg =(ImageView) findViewById(R.id.backimg);

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SgininActivity.this, firstActivity.class);
                startActivity(intent);
            }
        });

    }


}


