package com.example.duan.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan.database.DbHelper;
import com.example.duan.model.Brand;

import java.util.ArrayList;

public class BrandDao {
    private DbHelper dbHelper;
    public BrandDao(Context context){
        dbHelper=new DbHelper(context);
    }

    public ArrayList<Brand>getlistDS_Brand(){
        ArrayList<Brand> list=new ArrayList<>();
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM BRAND",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                list.add(new Brand(cursor.getInt(0),cursor.getString(1)));
            }while (cursor.moveToNext());
        }

        return list;

    }
}
