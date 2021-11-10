package com.example.hancongnhub17dccn481;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.hancongnhub17dccn481.adapter.AdapterAA;
import com.example.hancongnhub17dccn481.databinding.ActivityCcactivityBinding;
import com.example.hancongnhub17dccn481.model.LoaiMon_B17DCCN481;
import com.example.hancongnhub17dccn481.model.MonAn_B17DCCN481;
import com.example.hancongnhub17dccn481.model.QuanLi_B17DCCN481;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CCActivity extends AppCompatActivity {
    ActivityCcactivityBinding binding;
    AdapterAA adapterAA;
    //chuoi du lieu cho spinner
    List<String> spin_ds_ma = new ArrayList<>();
    List<String> spin_ds_lm = new ArrayList<>();
    //array lis cho spin_get_lop
    List<MonAn_B17DCCN481> ds_matypelm = new ArrayList<>();
    DataBaseHelper dataBaseHelper;
    QuanLi_B17DCCN481 quanLi_b17DCCN481;
    //chua du lieu tu databae
    List<LoaiMon_B17DCCN481> everyloaimon=new ArrayList<>();;
    List<MonAn_B17DCCN481> everymonan=new ArrayList<>();
    //de xu li bat su kien spinner
    int position_ma =0;
    int position_lm =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCcactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        dataBaseHelper = new DataBaseHelper(CCActivity.this);
        everyloaimon = dataBaseHelper.getEverythingBB();
        everymonan = dataBaseHelper.getEverythingAA();
        //spinner do du lieu mon an vao
        for (int i=0;i<everymonan.size();i++)
        {
            String infor_ma = "Mã ma: "+everymonan.get(i).getMaMon()+"  "+"Tênma: "+everymonan.get(i).getTenMon();
            spin_ds_ma.add(infor_ma);
        }
        ArrayAdapter<String> maadapter = new ArrayAdapter<String>(CCActivity.this,
                android.R.layout.simple_spinner_item,spin_ds_ma);
        binding.spinMonan.setAdapter(maadapter);
        //spinner do du lieu loai mon vao
        for (int i=0;i<everyloaimon.size();i++)
        {
            String infor_lm = "Mã lm: "+everyloaimon.get(i).getMaLoaiMon()+"  "+"Tên lm: "+everyloaimon.get(i).getTenLoaiMon();
            spin_ds_lm.add(infor_lm);
        }

        ArrayAdapter<String> lmadapter = new ArrayAdapter<String>(CCActivity.this,
                android.R.layout.simple_spinner_item,spin_ds_lm);
        binding.spinLoaimon.setAdapter(lmadapter);
        //spin ds sv theo lop hoc
        binding.spinTypeLoaimon.setAdapter(lmadapter);

        binding.spinMonan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position_ma = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.spinLoaimon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position_lm = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.spinTypeLoaimon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int maloaimon = everyloaimon.get(position).getMaLoaiMon();
                dataBaseHelper = new DataBaseHelper(CCActivity.this);
                ds_matypelm = dataBaseHelper.getEverythingCCbyBB(maloaimon);
                Toast.makeText(CCActivity.this,ds_matypelm.size()+"",Toast.LENGTH_SHORT).show();


                adapterAA = new AdapterAA(ds_matypelm, CCActivity.this);
                binding.rvDsMatypelm.setAdapter(adapterAA);
                binding.rvDsMatypelm.setLayoutManager(new LinearLayoutManager(CCActivity.this));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.addQuanli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    quanLi_b17DCCN481 = new QuanLi_B17DCCN481(everymonan.get(position_ma).getMaMon(),
                            everyloaimon.get(position_lm).getMaLoaiMon(),binding.editGhichu.getText().
                            toString());


                    dataBaseHelper = new DataBaseHelper(CCActivity.this);
                    boolean success = dataBaseHelper.addCC(quanLi_b17DCCN481);
                    Toast.makeText(CCActivity.this,"đăng kí thành công",Toast.LENGTH_SHORT).show();

                }catch (Exception e){

                    Toast.makeText(CCActivity.this,"Lõi",Toast.LENGTH_SHORT).show();
                }
//                dataBaseHelper = new DataBaseHelper(DangKiActivity.this);
//                boolean success = dataBaseHelper.addCC(dangKi);
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