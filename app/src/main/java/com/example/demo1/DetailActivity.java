package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        final String title=bundle.getString("title");
        int speed=bundle.getInt("speed");
        final String speedStr=speed+"";
        final String instrument=bundle.getString("instrument");
        Button button=findViewById(R.id.test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this,title+speedStr+instrument,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
