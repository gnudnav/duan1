package com.example.duan.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan.database.DbHelper;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class SanPham_WomanDao {
    private DbHelper dbHelper;
    public SanPham_WomanDao(Context context){
        dbHelper=new DbHelper(context);
    }
    public ArrayList<SanPham> getDsSanPhamWoman(){
        ArrayList<SanPham>list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM SANPHAM WHERE maloai=2",null);
        if(cursor.getCount()>0){
            cursor.moveToNext();
            do {
                list.add(new SanPham(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7)));
            }while (cursor.moveToNext());
        }


        return list;
    }
}
