package com.example.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan.database.DbHelper;
import com.example.duan.model.CTHD;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class CTHDDao {
    private DbHelper dbHelper;
    public CTHDDao(Context context){
        dbHelper=new DbHelper(context);
    }

    public ArrayList<CTHD> listgetDSCart(){
        ArrayList<CTHD> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT cthd.macthd, cthd.masanpham, hoadon.mahoadon, sanpham.gia, sanpham.imgsanpham, sanpham.ten, sanpham.tenbrand, sanpham.maloai, sanpham.soluong\n" +
                "FROM CTHD cthd\n" +
                "JOIN SANPHAM sanpham ON cthd.masanpham = sanpham.masanpham\n" +
                "JOIN HOADON hoadon ON cthd.mahoadon = hoadon.mahoadon",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new CTHD(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7),cursor.getInt(8)));
            }while (cursor.moveToNext());
        }

        return list;
    }
    public boolean xoaCart(int macthd){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();

        int check=sqLiteDatabase.delete("CTHD","macthd=?",new String[]{String.valueOf(macthd)});
        if(check<=0){
            return false;
        }else {
            return true;
        }
    }
    public void themCart(CTHD cthd){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("masanpham", cthd.getMasanpham());
        contentValues.put("gia", cthd.getGia());
        contentValues.put("soluong", cthd.getSoluong());
        contentValues.put("imgsanpham", cthd.getImgsanpham());
        contentValues.put("tenloai", cthd.getMaloai());
        // Các cột khác của bảng CTHD

        // Thêm dữ liệu vào bảng CTHD
        sqLiteDatabase.insert("CTHD", null,contentValues);

        sqLiteDatabase.close();
    }


}
