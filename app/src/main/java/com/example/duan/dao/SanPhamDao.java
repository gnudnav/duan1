package com.example.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.database.DbHelper;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class SanPhamDao {
    private DbHelper dbHelper;
    public SanPhamDao(Context context){
        dbHelper=new DbHelper(context);
    }

    public ArrayList<SanPham> listgetDSSANPHAM(){
        ArrayList<SanPham> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM SANPHAM",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new SanPham(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6)));
            }while (cursor.moveToNext());
        }

        return list;
    }
    public ArrayList<SanPham> listgetDS(){
        ArrayList<SanPham> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM SANPHAM WHERE trangthai=2 ",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new SanPham(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6)));
            }while (cursor.moveToNext());
        }

        return list;
    }
    public int updateTrangThai(int masanpham,int trangthai) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("trangthai", trangthai);

        db.update("SANPHAM", values,"masanpham=?",new String[]{String.valueOf(masanpham)});

        return trangthai;

    }
}
