package com.example.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan.database.DbHelper;
import com.example.duan.model.NguoiDung;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class NguoiDungDao {
    private DbHelper dbHelper;
    public NguoiDungDao(Context context){
        dbHelper=new DbHelper(context);
    }
    public boolean KiemTraDangNhap(String tendangnhap,String matkhau){
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tentaikhoan=? and matkhau=?",new String[]{tendangnhap,matkhau});
        return cursor.getCount()>0;
    }
    public boolean KiemTraSdt(String sdt){
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE sdt=?",new String[]{sdt});
        return cursor.getCount()>0;
    }
    public boolean DangKy(String tendangnhap,String matkhau,String sdt){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("tentaikhoan",tendangnhap);
        contentValues.put("matkhau",matkhau);
        contentValues.put("sdt",sdt);
        long check=sqLiteDatabase.insert("NGUOIDUNG",null,contentValues);
        return check!=-1;
    }
    public ArrayList<NguoiDung> listgetDSNGUOIDUNG(){
        ArrayList<NguoiDung> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new NguoiDung(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            }while (cursor.moveToNext());
        }

        return list;
    }


}
