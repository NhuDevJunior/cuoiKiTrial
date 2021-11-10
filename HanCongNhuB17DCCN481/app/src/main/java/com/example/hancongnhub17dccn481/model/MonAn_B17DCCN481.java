package com.example.hancongnhub17dccn481.model;

public class MonAn_B17DCCN481 {
    private int maMon;
    private String tenMon;
    private int giadat;
    private int thoigian;

    public MonAn_B17DCCN481() {
    }

    public MonAn_B17DCCN481(int maMon, String tenMon, int giadat, int thoigian) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.giadat = giadat;
        this.thoigian = thoigian;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getGiadat() {
        return giadat;
    }

    public void setGiadat(int giadat) {
        this.giadat = giadat;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    @Override
    public String toString() {
        return "MonAn_B17DCCN481{" +
                "maMon=" + maMon +
                ", tenMon='" + tenMon + '\'' +
                ", giadat=" + giadat +
                ", thoigian='" + thoigian + '\'' +
                '}';
    }
}
