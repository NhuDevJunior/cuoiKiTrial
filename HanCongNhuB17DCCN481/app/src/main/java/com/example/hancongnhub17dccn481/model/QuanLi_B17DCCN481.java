package com.example.hancongnhub17dccn481.model;

public class QuanLi_B17DCCN481 {
    private int maMon,maLoaiMon;
    private String chuthic;

    public QuanLi_B17DCCN481(int maMon, int maLoaiMon, String chuthic) {
        this.maMon = maMon;
        this.maLoaiMon = maLoaiMon;
        this.chuthic = chuthic;
    }

    public QuanLi_B17DCCN481() {
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public int getMaLoaiMon() {
        return maLoaiMon;
    }

    public void setMaLoaiMon(int maLoaiMon) {
        this.maLoaiMon = maLoaiMon;
    }

    public String getChuthic() {
        return chuthic;
    }

    public void setChuthic(String chuthic) {
        this.chuthic = chuthic;
    }

    @Override
    public String toString() {
        return "QuanLi_B17DCCN481{" +
                "maMon=" + maMon +
                ", maLoaiMon=" + maLoaiMon +
                ", chuthic='" + chuthic + '\'' +
                '}';
    }
}
