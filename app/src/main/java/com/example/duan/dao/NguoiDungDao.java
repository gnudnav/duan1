package com.example.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan.database.DbHelper;
import com.example.duan.model.NguoiDung;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class NguoiDungDao {
    private DbHelper dbHelper;

    private SharedPreferences sharedPreferences;

    public NguoiDungDao(Context context) {
        this.dbHelper = new DbHelper(context);
        sharedPreferences=context.getSharedPreferences("dataUser",Context.MODE_PRIVATE);
    }

    public boolean KiemTraDangNhap(String tendangnhap, String matkhau){
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tentaikhoan=? and matkhau=?",new String[]{tendangnhap,matkhau});
        if(cursor.moveToFirst()){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("role",cursor.getInt(7));
            editor.apply();
        }
        return cursor.getCount()>0;
    }
    public boolean KiemTraSdt(String sdt){
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE sdt=?",new String[]{sdt});
        return cursor.getCount()>0;
    }
    public boolean DangKy(String tendangnhap,String matkhau,String sdt,int role){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("tentaikhoan",tendangnhap);
        contentValues.put("matkhau",matkhau);
        contentValues.put("sdt",sdt);
        contentValues.put("role",role);
        long check=sqLiteDatabase.insert("NGUOIDUNG",null,contentValues);
        return check!=-1;
    }
}
