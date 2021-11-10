package com.example.hancongnhub17dccn481;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hancongnhub17dccn481.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.addAa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AAActivity.class);
                startActivity(intent);
            }
        });
        binding.addBb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BBActivity.class);
                startActivity(intent);
            }
        });
        binding.addCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CCActivity.class);
                startActivity(intent);
            }
        });
        binding.addThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThongkeActivity.class);
                startActivity(intent);
            }
        });
        binding.addLietke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LietkeActivity.class);
                startActivity(intent);
            }
        });
    }
}