package com.example.duan.model;

public class Brand {
    private int idbrand;
    private String imgbrand;

    public Brand(int idbrand, String imgbrand) {
        this.idbrand = idbrand;
        this.imgbrand = imgbrand;
    }

    public int getIdbrand() {
        return idbrand;
    }

    public void setIdbrand(int idbrand) {
        this.idbrand = idbrand;
    }

    public String getImgbrand() {
        return imgbrand;
    }

    public void setImgbrand(String imgbrand) {
        this.imgbrand = imgbrand;
    }
}
