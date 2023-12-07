package com.example.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.duan.activity.RegistonActivity;
import com.example.duan.database.DbHelper;
import com.example.duan.model.NguoiDung;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class NguoiDungDao {
    private Context context;
    private DbHelper dbHelper;

    private SharedPreferences sharedPreferences;

    public NguoiDungDao(Context context) {
        this.dbHelper = new DbHelper(context);
        sharedPreferences=context.getSharedPreferences("dataUser",Context.MODE_PRIVATE);
    }

    public boolean KiemTraDangNhap(String tendangnhap, String matkhau){
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tentaikhoan=? and matkhau=?",new String[]{tendangnhap,matkhau});
        int manguoidung=-1;
        if(cursor.moveToFirst()){
            manguoidung=cursor.getInt(0);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("manguoidung", manguoidung);
            editor.putInt("role",cursor.getInt(7));
            editor.apply();
        }

        return cursor.getCount()>0;
    }
    public boolean KiemTraSdt(String sdt){
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE sdt=?",new String[]{sdt});
        int manguoidung=-1;
        if(cursor.moveToFirst()){
            manguoidung=cursor.getInt(0);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("manguoidung", manguoidung);
            editor.apply();
        }
        return cursor.getCount()>0;
    }
    public boolean DangKy(String tendangnhap,String matkhau,String sdt){

        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("tentaikhoan",tendangnhap);
        contentValues.put("matkhau",matkhau);
        contentValues.put("sdt",sdt);
        contentValues.put("role",1);
        long check=sqLiteDatabase.insert("NGUOIDUNG",null,contentValues);
        return check!=-1;
    }
    public boolean DoiMatKhau(int manguoidung,String matkhau){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("matkhau",matkhau);
        long check=sqLiteDatabase.update("NGUOIDUNG",contentValues,"manguoidung=?",new String[]{String.valueOf(manguoidung)});
        return check!=-1;
    }
    public boolean updateAllPasswords(String newPassword) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("matkhau", newPassword);

        int rowsAffected = db.update("NGUOIDUNG", values, null, null);

//        Log.d("DbHelper", "Rows affected: " + rowsAffected);

        return rowsAffected > 0;
    }
    public boolean kiemtrasdtTonTai(int sdt) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM NGUOIDUNG WHERE sdt = ?";
        Cursor cursor = sqLiteDatabase.rawQuery(query, new String[]{String.valueOf(sdt)});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}
