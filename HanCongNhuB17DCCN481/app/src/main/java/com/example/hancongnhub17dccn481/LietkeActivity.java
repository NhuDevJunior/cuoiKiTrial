package com.example.hancongnhub17dccn481;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.hancongnhub17dccn481.adapter.AdapterAA;
import com.example.hancongnhub17dccn481.databinding.ActivityLietkeBinding;
import com.example.hancongnhub17dccn481.databinding.ActivityThongkeBinding;
import com.example.hancongnhub17dccn481.model.MonAn_B17DCCN481;

import java.util.ArrayList;
import java.util.List;

public class LietkeActivity extends AppCompatActivity {
    ActivityLietkeBinding binding;
    AdapterAA adapterAA;
    DataBaseHelper dataBaseHelper;
    List<MonAn_B17DCCN481> everymonan = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lietke);
        binding = ActivityLietkeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        dataBaseHelper = new DataBaseHelper(LietkeActivity.this);
        everymonan = dataBaseHelper.thongKe();
        adapterAA = new AdapterAA(everymonan, LietkeActivity.this);
        binding.rvLietke.setAdapter(adapterAA);
        binding.rvLietke.setLayoutManager(new LinearLayoutManager(LietkeActivity.this));

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}