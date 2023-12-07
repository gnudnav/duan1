package com.example.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
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
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT cthd.macthd, cthd.masanpham, hoadon.mahoadon,hoadon.trangthaihd,sanpham.gia, sanpham.imgsanpham, sanpham.ten, sanpham.tenbrand, sanpham.maloai,cthd.trangthaicthd,cthd.soluongcthd\n" +
                "FROM CTHD cthd\n" +
                "JOIN SANPHAM sanpham ON cthd.masanpham = sanpham.masanpham\n" +
                "JOIN HOADON hoadon ON cthd.mahoadon = hoadon.mahoadon WHERE hoadon.trangthaihd=1 \n",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new CTHD(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10)));
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
    public boolean themCTHD(int masanpham,int mahoadon,int trangthaicthd,int soluongcthd) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masanpham", masanpham);
        values.put("mahoadon",mahoadon);
        values.put("trangthaicthd",trangthaicthd);
        values.put("soluongcthd",soluongcthd);

        long result = db.insert("CTHD", null, values);
        db.close();

        return result != -1;
    }

    public boolean updateTrangThaiCTHD(int mahoadon){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("trangthai",2);
        long check = database.update("HoaDon",values,"mahoadon=?",new String[]{String.valueOf(mahoadon)});
        return check != -1;
    }
    public boolean updateTrangThaiHD(int mahoadon){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("trangthaihd",2);
        long check = database.update("HoaDon",values,"mahoadon=?",new String[]{String.valueOf(mahoadon)});
        return check != -1;
    }
    public void updateSoLuong(int macthd,int soluongcthd) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("soluongcthd", soluongcthd);
        db.update("CTHD", values,"macthd=?",new String[]{String.valueOf(macthd)});

        db.close();

    }
}
