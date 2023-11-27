package com.example.duan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "duan",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tNguoiDung="CREATE TABLE NGUOIDUNG(manguoidung integer primary key autoincrement,sdt integer," +
                "email text,diachi text,tentaikhoan text,matkhau text,hoten text)";
        db.execSQL(tNguoiDung);
        db.execSQL("INSERT INTO NGUOIDUNG VALUES(1,0123456789,'dung@gmal.com','dian','vandung','abc123','levandung')");


        String tSanPham="CREATE TABLE SANPHAM(masanpham integer primary key autoincrement,gia integer,imgsanpham text,ten text," +
                "tenbrand text references BRAND(tenbrand),maloai integer references LOAI(maloai))";
        db.execSQL(tSanPham);
        db.execSQL("INSERT INTO SANPHAM VALUES(1,8600000,'img_breguet_breguettradition','Breguet Tradition 7057BB/G9/9W6','ic_brand_breguet',1),(2,1000000,'img_breguet_breguetclassic','Breguet Classicque 714BR/12/9WU','ic_brand_breguet',1)," +
                "(3,900000,'img_breitling_avengerchronograph','Breitling Avenger Chronograph 45 Night Mission','ic_brand_breitling',2),(4,1000000,'img_breitling_beritling1884','Breitling Avenger Chronograph 45 Night Mission','ic_brand_breitling',2)," +
                "(5,500000,'img_couple_casio_casiodoi','Casio Đôi-Quarts(Pin)-Dây Da','brand_chanel',3),(6,2100000,'img_couple_koi_koidoi','Koi Đôi-Quarts(Pin)-Dây Da','brand_chanel',3)," +
                "(7,1900000,'img_man_seiko_seiko5','Seiko 5 Sports 55th Anniversary Limited Edition','brand_chanel',1)," +
                "(8,3600000,'img_chanel_j12caliber','j12caliber','brand_chanel',2)," +
                "(9,2200000,'img_couple_certina_certinadoi','Certina Đôi-Kính Sapphire-Automatic','brand_chanel',3)," +
                "(10,6800000,'img_man_citizen_citizenbi5070','Citizen Bi5070-57H-Nam','brand_citizen',1)," +
                "(11,9600000,'img_chanel_j12caliber','j12caliber','brand_chanel',2)," +
                "(12,4500000,'img_couple_koi_koidoi_sapphire','Koi Đôi-Kính Sapphire-Quarts(Pin)-Dây Da','brand_chanel',3)," +
                "(13,6500000,'img_man_srwatch_srsg19191','Sr Sg 1919.4101_Nam-Kính Sapphire-Automactic','brand_chanel',1)," +
                "(14,1000000,'img_chanel_j12caliber','j12caliber','brand_chanel',2)," +
                "(15,1200000,'img_couple_doxa_doxadoi_sapphire','Doxa Đôi-Kính Sapphire-Quarts(Pin)_Dây Kim Loại','brand_doxa',3)," +
                "(16,5600000,'img_man_gshock_gshockga','G-Shock Ga-B2100-1A1Dr-Nam-Tough-Solar','brand_chanel',1)," +
                "(17,3500000,'img_chanel_j12caliber','j12caliber','brand_chanel',2)," +
                "(18,900000,'img_couple_calvin_calvindoi_daykimloai','Calvin Klein Đôi-Quarts(Pin)-Dây Kim Loại','brand_chanel',3)," +
                "(19,1000000,'img_man_dw_dwiconic','Daniel Wellington Iconic Motion DW00100425-Nam-Quartz','brand_dw',1)," +
                "(20,2200000,'img_chanel_j12caliber','j12caliber','brand_chanel',2)," +
                "(21,3300000,'img_couple_citizen_citizendoi_eco','Citizen Đôi-Eco-Drive','brand_citizen',3)," +
                "(22,1200000,'img_man_casio_casioecb','Casio ECB-950DB-2ADF-Nam-Solar-Dây Kim Loại','brand_casio',1)," +
                "(23,1000000,'img_chanel_j12caliber','j12caliber','brand_chanel',2)," +
                "(24,2000000,'img_couple_tissot_tissotdoi_sapphire','Tissot Đôi-Kính Sapphire-Quartz(Pin)-Dây Kim Loại','brand_tissot',3)");
        String tBrand="CREATE TABLE BRAND(mabrand integer primary key autoincrement,tenbrand text)";
        db.execSQL(tBrand);
        db.execSQL("INSERT INTO BRAND VALUES(1,'ic_brand_breguet'),(2,'ic_brand_breitling'),(3,'ic_brand_chanel')," +
                "(4,'ic_brand_chopard'),(5,'ic_brand_citizen'),(6,'ic_brand_doxa'),(7,'ic_brand_dw')," +
                "(8,'ic_brand_hublot'),(9,'ic_brand_jaeger_lecoultre'),(10,'ic_brand_lacoste'),(11,'ic_brand_longines')," +
                "(12,'ic_brand_r'),(13,'ic_brand_rado'),(14,'ic_brand_rolex'),(15,'ic_brand_tissot')");


        String tLoai="CREATE TABLE LOAI(maloai integer primary key autoincrement,tenloai text)";
        db.execSQL(tLoai);
        db.execSQL("INSERT INTO LOAI VALUES(1,'man'),(2,'woman'),(3,'couple')");


//        trang thai
//        1:đang chờ
//        2:đã duyệt
        String tHoaDon="CREATE TABLE HOADON(mahoadon integer primary key autoincrement," +
                "ngaytao text,trangthai integer,manguoidung integer references NGUOIDUNG(manguoidung))";
        db.execSQL(tHoaDon);
        db.execSQL("INSERT INTO HOADON VALUES(1,'27/11/2023','1',1),(1,'27/11/2023','1',2)");


        String tCTHD="CREATE TABLE CTHD(macthd integer primary key autoincrement,masanpham integer references SANPHAM(masanpham),mahoadon integer references NGUOIDUNG(mahoadon),soluong integer)";
        db.execSQL(tCTHD);
        db.execSQL("INSERT INTO CTHD VALUES(1,1,1,1),(1,2,1,3)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
