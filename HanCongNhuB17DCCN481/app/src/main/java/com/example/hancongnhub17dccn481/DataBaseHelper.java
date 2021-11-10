package com.example.hancongnhub17dccn481;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.hancongnhub17dccn481.model.LoaiMon_B17DCCN481;
import com.example.hancongnhub17dccn481.model.MonAn_B17DCCN481;
import com.example.hancongnhub17dccn481.model.QuanLi_B17DCCN481;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    //bảng AA
    private static final String AA_TABLE = "BangMonAn";
    private static final String COLUMN_A0 = "MaMA";
    private static final String COLUMN_A1 = "TenMA";
    private static final String COLUMN_A2 = "GiaDat";
    private static final String COLUMN_A3 = "ThoiGianPV";


    //bảng BB
    private static final String BB_TABLE = "BangLoaiMon";
    private static final String COLUMN_B0 = "MaLM";
    private static final String COLUMN_B1 = "TenLM";
    private static final String COLUMN_B2 = "MoTa";
    //bảng CC
    private static final String CC_TABLE = "BangQuanLi";
    private static final String COLUMN_C0 = "MaMA";
    private static final String COLUMN_C1 = "MaLM";
    private static final String COLUMN_C2 = "GhiChu";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "B17DCCN481_QUANLITHUCDON.db", null, 1);
        //xoa database
//       context.deleteDatabase("cuoiki03.db");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableAA = "CREATE TABLE IF NOT EXISTS " + AA_TABLE + " ("+ COLUMN_A0 +
                " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMN_A1 + " TEXT,"+ COLUMN_A2+ " INTEGER,"+COLUMN_A3+" INTEGER)";
        String createTableBB = "CREATE TABLE IF NOT EXISTS " + BB_TABLE + " ("+ COLUMN_B0 +
                " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMN_B1 + " TEXT,"+COLUMN_B2+" TEXT)";
        String createTableCC = "CREATE TABLE IF NOT EXISTS "+CC_TABLE+" (" +COLUMN_C0+
                " INTEGER,"+COLUMN_C1+" INTEGER,"+COLUMN_C2+" TEXT,"+"PRIMARY KEY("+COLUMN_C0+","+COLUMN_C1+"))";
        db.execSQL(createTableAA);
        db.execSQL(createTableBB);
        db.execSQL(createTableCC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            String createTableBB = "CREATE TABLE IF NOT EXISTS " + BB_TABLE + " ("+ COLUMN_B0 +
                    " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMN_B1 + " TEXT,"+COLUMN_B2+" TEXT)";
            db.execSQL(createTableBB);
            onCreate(db);
        }
    }
    // thao tac voi bang AA
    public boolean addAA(MonAn_B17DCCN481 monAn_b17DCCN481)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_A1,monAn_b17DCCN481.getTenMon());
        cv.put(COLUMN_A2,monAn_b17DCCN481.getGiadat());
        cv.put(COLUMN_A3,monAn_b17DCCN481.getThoigian());
        db.insert(AA_TABLE,null,cv);
        db.close();
        return true;
    }
    public boolean deleteAA(MonAn_B17DCCN481 monAn_b17DCCN481)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        String queryString = "DELETE FROM "+AA_TABLE+" WHERE "+COLUMN_A0+" = "+monAn_b17DCCN481.getMaMon();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst())
        {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }
    public List<MonAn_B17DCCN481> getEverythingAA()
    {
        List<MonAn_B17DCCN481> returnList = new ArrayList<>();
        String queryString = "SELECT* FROM "+AA_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst())
        {
            do{
                int maMA = cursor.getInt(0);
                String tenMA = cursor.getString(1);
                int giadat = cursor.getInt(2);
                int thoigian = cursor.getInt(3);
                MonAn_B17DCCN481 monAn_b17DCCN481 = new MonAn_B17DCCN481(maMA,tenMA,giadat,thoigian);
                returnList.add(monAn_b17DCCN481);
            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
//        db.close();
        return returnList;

    }
    //thao tac voi bang bb
    public boolean addBB(LoaiMon_B17DCCN481 loaiMon_b17DCCN481)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_B1,loaiMon_b17DCCN481.getTenLoaiMon());
        cv.put(COLUMN_B2,loaiMon_b17DCCN481.getMota());
        db.insert(BB_TABLE,null,cv);
//        db.close();
        return true;
    }
    public boolean deleteBB(LoaiMon_B17DCCN481 loaiMon_b17DCCN481)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        String queryString = "DELETE FROM "+BB_TABLE+" WHERE "+COLUMN_B0+" = "+loaiMon_b17DCCN481.getMaLoaiMon();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst())
        {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }
    public List<LoaiMon_B17DCCN481> getEverythingBB()
    {
        List<LoaiMon_B17DCCN481> returnList = new ArrayList<>();
        String queryString = "SELECT* FROM "+BB_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst())
        {
            do{
                int maLM = cursor.getInt(0);
                String tenLM = cursor.getString(1);
                String mota = cursor.getString(2);
                LoaiMon_B17DCCN481 loaiMon_b17DCCN481  = new LoaiMon_B17DCCN481(maLM,tenLM,mota);
                returnList.add(loaiMon_b17DCCN481);
            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
//        db.close();
        return returnList;

    }
    //thao tao voi bang cc
    public boolean addCC(QuanLi_B17DCCN481 quanLi_b17DCCN481)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_C0,quanLi_b17DCCN481.getMaMon());
        cv.put(COLUMN_C1,quanLi_b17DCCN481.getMaLoaiMon());
        cv.put(COLUMN_C2,quanLi_b17DCCN481.getChuthic());
        db.insert(CC_TABLE,null,cv);
//        db.close();
        return true;
    }
    //lay danh sach sinh vien theo ma lop
    public List<MonAn_B17DCCN481> getEverythingCCbyBB(int maBB)
    {
        List<MonAn_B17DCCN481> returnList = new ArrayList<>();
        String queryString = "SELECT* FROM "+AA_TABLE+
                " INNER JOIN "+CC_TABLE+" ON "+CC_TABLE+"."+COLUMN_C0+" = "
                +AA_TABLE+"."+COLUMN_A0+" WHERE "+CC_TABLE+"."+COLUMN_C1+" = "+maBB;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst())
        {
            do{
                int maMA = cursor.getInt(0);
                String tenMA = cursor.getString(1);
                int giadat = cursor.getInt(2);
                int thoigian = cursor.getInt(3);
                MonAn_B17DCCN481 monAn_b17DCCN481 = new MonAn_B17DCCN481(maMA,tenMA,giadat,thoigian);
                returnList.add(monAn_b17DCCN481);
            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
//        db.close();
        return returnList;

    }
    public List<MonAn_B17DCCN481> thongKe()
    {
        List<MonAn_B17DCCN481> returnList = new ArrayList<>();
        int property_0 = 200;
        int property_1 = 15;
        String queryString = "SELECT* FROM "+AA_TABLE+" WHERE "+COLUMN_A2+" = "+property_0+" AND "+COLUMN_A3+" < "+property_1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst())
        {
            do{
                int maMA = cursor.getInt(0);
                String tenMA = cursor.getString(1);
                int giadat = cursor.getInt(2);
                int thoigian = cursor.getInt(3);
                MonAn_B17DCCN481 monAn_b17DCCN481 = new MonAn_B17DCCN481(maMA,tenMA,giadat,thoigian);
                returnList.add(monAn_b17DCCN481);
            }while (cursor.moveToNext());
        }
        else {

        }
        cursor.close();
//        db.close();
        return returnList;

    }
}
