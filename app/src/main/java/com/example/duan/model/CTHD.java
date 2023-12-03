package com.example.duan.model;

public class CTHD {
    private int macthd;
    private int masanpham;
    private int mahd;
    private int trangthai;
    private int gia;
    private String imgsanpham;
    private String ten;
    private String tenbrand;
    private int maloai;
    private int soluong;


    public CTHD(int macthd, int masanpham, int mahd, int trangthai, int gia, String imgsanpham, String ten, String tenbrand, int maloai, int soluong) {
        this.macthd = macthd;
        this.masanpham = masanpham;
        this.mahd = mahd;
        this.trangthai = trangthai;
        this.gia = gia;
        this.imgsanpham = imgsanpham;
        this.ten = ten;
        this.tenbrand = tenbrand;
        this.maloai = maloai;
        this.soluong = soluong;
    }

    public int getMacthd() {
        return macthd;
    }

    public void setMacthd(int macthd) {
        this.macthd = macthd;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
