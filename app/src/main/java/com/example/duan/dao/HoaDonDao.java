package com.example.duan.dao;

import android.content.ContentValues;
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

    public int themHD() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Kiểm tra xem có hoa don hiện tại với trạng thái 1 hay 2 không
        Cursor cursor = db.rawQuery("SELECT mahoadon FROM HOADON WHERE manguoidung = 1 AND trangthaihd = 1", null);

        int existingMahoadon;
        if (cursor.moveToFirst()) {
            // Nếu có hoá đơn với trạng thái 1, lấy mã hoá đơn hiện tại
            existingMahoadon = cursor.getInt(cursor.getColumnIndex("mahoadon"));
        } else {
            // Nếu không có hoá đơn với trạng thái 1, tạo một hoá đơn mới với trạng thái 1
            ContentValues values = new ContentValues();
            values.put("trangthaihd", 1);
            values.put("manguoidung", 1);
            long mahoadon = db.insert("HOADON", null, values);
            existingMahoadon = (int) mahoadon;
        }

        cursor.close();
        db.close();

        return existingMahoadon;
    }
}
