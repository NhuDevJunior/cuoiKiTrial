package com.example.hancongnhub17dccn481.model;

public class LoaiMon_B17DCCN481 {
     private int MaLoaiMon;
     private String tenLoaiMon;
     private String mota;

    public LoaiMon_B17DCCN481(int maLoaiMon, String tenLoaiMon, String mota) {
        MaLoaiMon = maLoaiMon;
        this.tenLoaiMon = tenLoaiMon;
        this.mota = mota;
    }

    public LoaiMon_B17DCCN481() {
    }

    public int getMaLoaiMon() {
        return MaLoaiMon;
    }

    public void setMaLoaiMon(int maLoaiMon) {
        MaLoaiMon = maLoaiMon;
    }

    public String getTenLoaiMon() {
        return tenLoaiMon;
    }

    public void setTenLoaiMon(String tenLoaiMon) {
        this.tenLoaiMon = tenLoaiMon;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "LoaiMon_B17DCCN481{" +
                "MaLoaiMon=" + MaLoaiMon +
                ", tenLoaiMon='" + tenLoaiMon + '\'' +
                ", mota='" + mota + '\'' +
                '}';
    }
}
