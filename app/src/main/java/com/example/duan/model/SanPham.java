package com.example.duan.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int masanpham;
    private int gia;
    private String imgsanpham;
    private String ten;
    private String tenbrand;
    private int maloai;

    public SanPham(int masanpham, int gia, String imgsanpham, String ten, String tenbrand, int maloai) {
        this.masanpham = masanpham;
        this.gia = gia;
        this.imgsanpham = imgsanpham;
        this.ten = ten;
        this.tenbrand = tenbrand;
        this.maloai = maloai;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getImgsanpham() {
        return imgsanpham;
    }

    public void setImgsanpham(String imgsanpham) {
        this.imgsanpham = imgsanpham;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenbrand() {
        return tenbrand;
    }

    public void setTenbrand(String tenbrand) {
        this.tenbrand = tenbrand;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }
}
