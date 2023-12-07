package com.example.duan.model;

public class CTHD {
    private int macthd;
    private int masanpham;
    private int mahd;
    private int trangthaihd;
    private int gia;
    private String imgsanpham;
    private String ten;
    private String tenbrand;
    private int maloai;
    private int trangthaicthd;
    private int soluongcthd;

    public CTHD(int macthd, int masanpham, int mahd, int trangthaihd, int gia, String imgsanpham, String ten, String tenbrand, int maloai, int trangthaicthd, int soluongcthd) {
        this.macthd = macthd;
        this.masanpham = masanpham;
        this.mahd = mahd;
        this.trangthaihd = trangthaihd;
        this.gia = gia;
        this.imgsanpham = imgsanpham;
        this.ten = ten;
        this.tenbrand = tenbrand;
        this.maloai = maloai;
        this.trangthaicthd = trangthaicthd;
        this.soluongcthd = soluongcthd;
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

    public int getTrangthaihd() {
        return trangthaihd;
    }

    public void setTrangthaihd(int trangthaihd) {
        this.trangthaihd = trangthaihd;
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

    public int getTrangthaicthd() {
        return trangthaicthd;
    }

    public void setTrangthaicthd(int trangthaicthd) {
        this.trangthaicthd = trangthaicthd;
    }

    public int getSoluongcthd() {
        return soluongcthd;
    }

    public void setSoluongcthd(int soluongcthd) {
        this.soluongcthd = soluongcthd;
    }
}
