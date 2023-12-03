package com.example.duan.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan.database.DbHelper;
import com.example.duan.model.CTHD;
import com.example.duan.model.HoaDon;
import com.example.duan.model.NguoiDung;

import java.util.ArrayList;

public class HoaDonDao {
    private DbHelper dbHelper;
    public HoaDonDao(Context context){
        dbHelper=new DbHelper(context);
    }

    public ArrayList<HoaDon> listgetHoaDon1(){
        ArrayList<HoaDon> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT hd.mahoadon, hd.trangthai, nd.manguoidung, nd.sdt, nd.email, nd.diachi, nd.tentaikhoan, nd.matkhau, nd.hoten " +
                "FROM HOADON hd " +
                "JOIN NGUOIDUNG nd ON hd.manguoidung = nd.manguoidung",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new HoaDon(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
            }while (cursor.moveToNext());
        }

        return list;
    }
    public ArrayList<HoaDon> listgetHoaDon2(){
        ArrayList<HoaDon> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT hd.mahoadon,hd.trangthai,nd.manguoidung,nd.sdt,nd.email,nd.diachi,nd.tentaikhoan,nd.matkhau,nd.hoten\n" +
                "FROM HOADON hd\n" +
                "JOIN NGUOIDUNG nd ON hd.masanpham = nd.masanpham WHERE hd.trangthai=2",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new HoaDon(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
            }while (cursor.moveToNext());
        }

        return list;
    }
}
