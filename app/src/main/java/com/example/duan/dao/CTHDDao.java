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
    public boolean themCTHD(int masanpham) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masanpham", masanpham);
        values.put("mahoadon",1);

        long result = db.insert("CTHD", null, values);
        db.close();

        return result != -1;
    }
}
