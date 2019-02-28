package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView categoryNumber = findViewById(R.id.category_number);
        categoryNumber.setOnClickListener(v->openNumberList(v));
    }

    public void openNumberList(View view){
        Intent i = new Intent(this,NumbersActivity.class);
        startActivity(i);
    }

}
