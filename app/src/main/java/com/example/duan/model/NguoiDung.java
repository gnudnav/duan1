package com.example.duan.model;

public class NguoiDung {
    private int manguoidung;
    private int sdt;
    private String email;
    private String diachi;
    private String tentaikhoan;
    private String matkhau;
    private String hoten;

    public NguoiDung(int manguoidung, int sdt, String email, String diachi, String tentaikhoan, String matkhau, String hoten) {
        this.manguoidung = manguoidung;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
        this.hoten = hoten;
    }

    public int getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        this.manguoidung = manguoidung;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
