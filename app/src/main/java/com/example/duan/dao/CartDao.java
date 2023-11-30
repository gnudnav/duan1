package com.example.duan.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan.database.DbHelper;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class CartDao {
    private DbHelper dbHelper;
    public CartDao(Context context){
        dbHelper=new DbHelper(context);
    }

    public ArrayList<SanPham> listgetDSCart(){
        ArrayList<SanPham> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM CART",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new SanPham(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6)));
            }while (cursor.moveToNext());
        }

        return list;
    }
    public boolean xoaCart(int masanpham){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM  CART WHERE masanpham=?",new String[]{String.valueOf(masanpham)});
        int check=sqLiteDatabase.delete("CART","maloai=?",new String[]{String.valueOf(masanpham)});
        if(check<=0){
            return false;
        }else {
            return true;
        }
    }
}
