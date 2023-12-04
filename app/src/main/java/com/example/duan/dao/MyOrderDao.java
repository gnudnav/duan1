package com.example.duan.dao;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan.database.DbHelper;
import com.example.duan.model.CTHD;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class MyOrderDao {
    private DbHelper dbHelper;
    public MyOrderDao(Context context){
        dbHelper=new DbHelper(context);
    }
    public ArrayList<CTHD> listgetDS(){
        ArrayList<CTHD> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT cthd.macthd, cthd.masanpham, hoadon.mahoadon, hoadon.trangthai, sanpham.gia, sanpham.imgsanpham, sanpham.ten, sanpham.tenbrand, sanpham.maloai, sanpham.soluong\n" +
                "FROM CTHD cthd\n" +
                "JOIN SANPHAM sanpham ON cthd.masanpham = sanpham.masanpham\n" +
                "JOIN HOADON hoadon ON cthd.mahoadon = hoadon.mahoadon\n" +
                "WHERE hoadon.trangthai = 1;",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new CTHD(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getInt(8),cursor.getInt(9)));
            }while (cursor.moveToNext());
        }

        return list;
    }
    public ArrayList<CTHD> listgetDSHistory(){
        ArrayList<CTHD> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT cthd.macthd, cthd.masanpham, hoadon.mahoadon, hoadon.trangthai, sanpham.gia, sanpham.imgsanpham, sanpham.ten, sanpham.tenbrand, sanpham.maloai, sanpham.soluong\n" +
                "FROM CTHD cthd\n" +
                "JOIN SANPHAM sanpham ON cthd.masanpham = sanpham.masanpham\n" +
                "JOIN HOADON hoadon ON cthd.mahoadon = hoadon.mahoadon\n" +
                "WHERE hoadon.trangthai = 2;",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new CTHD(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getInt(8),cursor.getInt(9)));
            }while (cursor.moveToNext());
        }

        return list;
    }

}
