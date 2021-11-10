package com.example.hancongnhub17dccn481;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hancongnhub17dccn481.adapter.AdapterAA;
import com.example.hancongnhub17dccn481.databinding.ActivityAaactivityBinding;
import com.example.hancongnhub17dccn481.inter.OnItemClickListener;
import com.example.hancongnhub17dccn481.model.MonAn_B17DCCN481;

import java.util.ArrayList;
import java.util.List;

public class AAActivity extends AppCompatActivity {
    ActivityAaactivityBinding binding;
    MonAn_B17DCCN481 monAn_b17DCCN481;
    List<MonAn_B17DCCN481> everymonan=new ArrayList<>();;
    private AdapterAA adapterAA;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAaactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        showMonAnRecycleView();
        eventClinkItem();
        binding.addMonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.editTenmonan.getText().toString().equals(""))
                {
                    Toast.makeText(AAActivity.this, "Yêu cầu nhập tên món ăn", Toast.LENGTH_LONG).show();
                }
                else {
                    monAn_b17DCCN481 = new MonAn_B17DCCN481(-1, binding.editTenmonan.getText().toString(),
                            Integer.parseInt(binding.editGiadat.getText().toString()),Integer.parseInt(binding.editThogianphucvu.getText().toString()));
                    Toast.makeText(AAActivity.this, monAn_b17DCCN481.toString(), Toast.LENGTH_LONG).show();
                    dataBaseHelper = new DataBaseHelper(AAActivity.this);
                    boolean success = dataBaseHelper.addAA(monAn_b17DCCN481);
                    showMonAnRecycleView();
                    eventClinkItem();
                }
            }

        });

    }
    private void showMonAnRecycleView() {
        dataBaseHelper = new DataBaseHelper(AAActivity.this);
        everymonan = dataBaseHelper.getEverythingAA();
        adapterAA = new AdapterAA(everymonan, AAActivity.this);
        binding.rvDsMonan.setAdapter(adapterAA);
        binding.rvDsMonan.setLayoutManager(new LinearLayoutManager(AAActivity.this));
    }

    private void eventClinkItem()
    {
        adapterAA.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MonAn_B17DCCN481 monAn_b17DCCN481 = everymonan.get(position);
//             boolean status = dataBaseHelper.deleteAA(sinhVien);
                Toast.makeText(AAActivity.this,monAn_b17DCCN481.getTenMon(),Toast.LENGTH_SHORT).show();
                showMonAnRecycleView();
                eventClinkItem();
            }
        });
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