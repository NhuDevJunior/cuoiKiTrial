package com.example.hancongnhub17dccn481;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.hancongnhub17dccn481.adapter.AdapterBB;
import com.example.hancongnhub17dccn481.databinding.ActivityBbactivityBinding;
import com.example.hancongnhub17dccn481.inter.OnItemClickListener;
import com.example.hancongnhub17dccn481.model.LoaiMon_B17DCCN481;

import java.util.ArrayList;
import java.util.List;

public class BBActivity extends AppCompatActivity {
    ActivityBbactivityBinding binding;
    LoaiMon_B17DCCN481 loaiMon_b17DCCN481;
    List<LoaiMon_B17DCCN481> everyloaimon=new ArrayList<>();;
    private AdapterBB adapterBB;
    String tenloai;
    DataBaseHelper dataBaseHelper;
    private static final String[] list_tenloai = {"Tráng miệng","khai vị","chính","chay","chuyên bò","chuyên gà"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBbactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //do du lieu vao spinner ten loai
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBActivity.this,
                android.R.layout.simple_spinner_item,list_tenloai);
        binding.spinTenloaimon.setAdapter(adapter);
        //auto load recycleView
        showLoaiMonRecycleView();
        eventClinkItem();
        binding.spinTenloaimon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tenloai = list_tenloai[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.addLoaimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaiMon_b17DCCN481 = new LoaiMon_B17DCCN481(-1, tenloai,
                        binding.editMota.getText().toString());
                Toast.makeText(BBActivity.this, loaiMon_b17DCCN481.toString(), Toast.LENGTH_LONG).show();
                dataBaseHelper = new DataBaseHelper(BBActivity.this);
                boolean success = dataBaseHelper.addBB(loaiMon_b17DCCN481);
                showLoaiMonRecycleView();
                eventClinkItem();
            }
        });


    }
    private void showLoaiMonRecycleView() {
        dataBaseHelper = new DataBaseHelper(BBActivity.this);
        everyloaimon = dataBaseHelper.getEverythingBB();
        adapterBB = new AdapterBB(everyloaimon, BBActivity.this);
        binding.rvDsLoaimon.setAdapter(adapterBB);
        binding.rvDsLoaimon.setLayoutManager(new LinearLayoutManager(BBActivity.this));
    }

    private void eventClinkItem()
    {
        adapterBB.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LoaiMon_B17DCCN481 loaiMon_b17DCCN481 = everyloaimon.get(position);
//             boolean status = dataBaseHelper.deleteAA(sinhVien);
                Toast.makeText(BBActivity.this,loaiMon_b17DCCN481.getTenLoaiMon(),Toast.LENGTH_SHORT).show();
                showLoaiMonRecycleView();
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