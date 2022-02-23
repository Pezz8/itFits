package com.example.itfits;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telecom.Connection;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Login.db";

    public DBHelper(Context context){
        super(context, "Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key, password TEXT)");
        db.execSQL("create Table sizeChart(brand TEXT, gender TEXT, type TEXT, size CHAR(4), " +
                "chestMin NUMBER(3,1), chestMax NUMBER(3,1)," +
                "  waistMin NUMBER(3,1),  waistMax NUMBER(3,1), " +
                "hipsMin NUMBER(3,1),  hipsMax NUMBER(3,1),  inseam NUMBER(3,1))");
        db.execSQL("create Table usersSize(userName_fk TEXT NOT NULL, gender TEXT, chest NUMBER(3,1), waist NUMBER(3,1), hips NUMBER(3,1), inseam NUMBER(3,1),FOREIGN KEY(userName_fk)REFERENCES users(username))");


        db.execSQL("INSERT INTO sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)VALUES('Adidas', 'Women', 'Tops', 'XS', 31,33,22.5,25,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Tops', 'S', 33.5,35,25.5,27.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Tops', 'M', 35.5,38,28,30,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Tops', 'L', 38.5,41,30.5,33,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Tops', 'XL', 41.5,44,33.5,36,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Bottoms', 'XS', 0,0,22.5,25,33,35,30)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Bottoms', 'S', 0,0,25,27.5,35,37.5,30.5)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Bottoms', 'M', 0,0,27.5,30,37.5,40.5,31)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Bottoms', 'L', 0,0,30,33,40.5,43.5,31.5)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Women', 'Bottoms', 'XL', 0,0,33,36,43.5,46.5,32)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Tops', 'XS', 31,33,27,29,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Tops', 'S', 34,37,30,32,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Tops', 'M', 37,40,32,35,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Tops', 'L', 40,44,35,39,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Tops', 'XL', 44,48,37,43,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Tops', 'XXL', 48,52,43,47,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Tops', 'XXXL', 53,58,48,53,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Bottoms', 'XS', 0,0,27,30,32,35,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Bottoms', 'S', 0,0,30,32,35,37,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Bottoms', 'M', 0,0,32,35,37,40,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Bottoms', 'L', 0,0,35,39,40,44,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Bottoms', 'XL', 0,0,39,43,44,48,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Bottoms', 'XXL', 0,0,43,47,48,51,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Adidas', 'Men', 'Bottoms', 'XXXL', 0,0,47,53,51,56,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Nike', 'Men', 'Tops', 'XS', 29.5,32.5,23.5,26,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Nike', 'Men', 'Tops', 'S', 32.5,35.5,26,29,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Nike', 'Men', 'Tops', 'M', 38,40.5,29,31.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Nike', 'Men', 'Tops', 'L', 41,44,31.5,34.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Nike', 'Men', 'Tops', 'XL', 44.5,48.5,34.5,38.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)VALUES('Nike', 'Women', 'Tops', 'XS', 29.5,32.5,23.5,26,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)VALUES('Nike', 'Women', 'Tops', 'S', 31.5,35.5,26,29,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)VALUES('Nike', 'Women', 'Tops', 'L', 38,41,31.5,34.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)VALUES('Nike', 'Women', 'Tops', 'XL', 41,44.5,34.5,38.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)VALUES('Nike', 'Women', 'Tops', 'XXL', 44.5,48.5,38.5,42.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)VALUES('Nike', 'Women', 'Tops', 'XXL', 44.5,48.5,38.5,42.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Tops', 'XXS', 28,30,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Tops', 'XS', 30,32,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Tops', 'S', 32,34,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Tops', 'M', 34,36,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Tops', 'L', 36,38,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Tops', 'XL', 38,40,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Tops', 'XXL', 40,42,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Tops', 'XXXL', 42,44,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Bottoms', 'XXS',0,0,22,23,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Bottoms', 'XS',0,0,23,25,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Bottoms', 'S',0,0,25,27,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Bottoms', 'M',0,0,27,29,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Bottoms', 'L',0,0,29,31,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Bottoms', 'XL',0,0,31,34,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Women', 'Bottoms', 'XXL',0,0,34,36,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Tops', 'XXS',30,32,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Tops', 'XS',32,34,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Tops', 'S',34,36,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Tops', 'M',36,38,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Tops', 'L',38,40,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Tops', 'XL',40,42,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Tops', 'XXL',42,44,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Bottoms', 'XXS',0,0,26,28,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Bottoms', 'XS',0,0,28,30,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Bottoms', 'S',0,0,30,32,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Bottoms', 'M',0,0,32,34,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Bottoms', 'L',0,0,34,36,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Bottoms', 'XL',0,0,36,38,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Diesel', 'Men', 'Bottoms', 'XXL',0,0,38,40,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Tops', 'XXS',30,32,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Tops', 'XS',32,33,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Tops', 'S',33,34.5,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Tops', 'M',34.5,35.5,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Tops', 'L',35.5,37,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Tops', 'XL',37,38.5,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Tops', 'XXL',38.5,40.5,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Bottoms', 'XXS',0,0,22,24,33.5,34.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Bottoms', 'XS',0,0,24,25.5,34.5,35.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Bottoms', 'S',0,0,25.5,26.5,35.5,37,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Bottoms', 'M',0,0,26.5,27.5,37,38.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Bottoms', 'L',0,0,27.5,29,28.5,39.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Bottoms', 'XL',0,0,29,30.5,39.5,41.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Women', 'Bottoms', 'XXL',0,0,30.5,32.5,41.5,43,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Men', 'Tops', 'XS',32,34,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Men', 'Tops', 'S',34,36,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Men', 'Tops', 'M',36,38,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Men', 'Tops', 'L',38,40,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Men', 'Tops', 'XL',40,42,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Gucci', 'Men', 'Tops', 'XXS',42,44,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Hugo Boss', 'Men', 'Tops', 'XS',32,34.5,28.5,30.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Hugo Boss', 'Men', 'Tops', 'S',34.5,36,30.5,32.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Hugo Boss', 'Men', 'Tops', 'M',36,38,32.5,34,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Hugo Boss', 'Men', 'Tops', 'L',38,39.5,34,35.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Hugo Boss', 'Men', 'Tops', 'XL',39.5,41,35.5,37,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Hugo Boss', 'Men', 'Tops', 'XXL',41,42.5,37,38.5,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Women', 'Tops', 'S',34,37,28,31,35.5,38.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Women', 'Tops', 'M',37,40,31,34,38.5,41.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Women', 'Tops', 'L',40,43,34,37,41.5,44.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Women', 'Tops', 'XL',43,46,37.5,40,44.5,47.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Women', 'Tops', 'XXL',46,49,40,43,47.5,50.5,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Men', 'Tops', 'S',34,38,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Men', 'Tops', 'M',38,42,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Men', 'Tops', 'L',42,46,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Men', 'Tops', 'XL',46,50,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Lee', 'Men', 'Tops', 'XXL',50,54,0,0,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Tops', 'XXS',28,30,23,24,34,35,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Tops', 'XS',30,32,24,25,35,36,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Tops', 'S',32,34,25,26,36,37,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Tops', 'M',34,36,28,29,37,39,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Tops', 'L',36,38,29,31,39,41,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Tops', 'XL',38,40,31,34,41,44,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Tops', 'XXL',40,42,34,36,44,46,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Tops', 'XXXL',42,44,36,38,46,48,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Bottoms', 'XXS',0,0,22,24,34,35,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Bottoms', 'XS',0,0,24,25,35,36,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Bottoms', 'S',0,0,25,26,36,37,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Bottoms', 'M',0,0,26,29,37,39,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Bottoms', 'L',0,0,29,31,39,41,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Bottoms', 'XL',0,0,31,34,41,44,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Bottoms', 'XXL',0,0,34,36,44,46,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Women', 'Bottoms', 'XXXL',0,0,36,38,46,48,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Tops', 'XXS',30,32,29,30,26,27,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Tops', 'XS',32,33,30,33,27,30,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Tops', 'S',33,34,33,36,30,32,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Tops', 'M',34,34.5,36,39,32,34,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Tops', 'L',34.5,36,39,42,34,37,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Tops', 'XL',36,36.5,42,45,37,41,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Tops', 'XXL',36.5,37,45,48,41,45,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Tops', 'XXXL',37,38,48,52,45,49,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Bottoms', 'XXS',0,0,25,27,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Bottoms', 'XS',0,0,27,30,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Bottoms', 'S',0,0,30,32,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Bottoms', 'M',0,0,32,34,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Bottoms', 'L',0,0,34,37,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Bottoms', 'XL',0,0,37,41,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Bottoms', 'XXL',0,0,41,45,0,0,0)");
        db.execSQL("insert into sizeChart(brand,gender,type,size,chestMin,chestMax,waistMin,waistMax,hipsMin,hipsMax,inseam)values('Puma', 'Men', 'Bottoms', 'XXXL',0,0,45,49,0,0,0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
        db.execSQL("drop Table if exists usersSize");
        db.execSQL("drop table if exists sizeChart");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password",password);
        long result = myDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else return true;
    }

    public Boolean insertSizeData(String username, String gender, Double chest, Double waist, Double hips, Double inseam){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName_fk",username);
        contentValues.put("gender", gender);
        contentValues.put("chest", chest);
        contentValues.put("waist", waist);
        contentValues.put("hips", hips);
        contentValues.put("inseam", inseam);
        long result = myDB.insert("usersSize",null,contentValues);
        if(result==-1) return false;
        else return true;
    }

    public Boolean checkUserName(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount()>0) return true;
        else return false;
    }

    public Boolean checkUserNamePassword(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?", new String[]{username,password});
        if(cursor.getCount() > 0) return true;
        else return false;
    }

    public UserSize getUserSizeFromDB(String userName){
        UserSize temp = new UserSize();
        SQLiteDatabase db = this.getReadableDatabase();
        String query= ("SELECT * FROM usersSize WHERE userName_fk = " + "\"" + userName + "\"");
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
        temp.setUserName(cursor.getString(0));
        temp.setGender(cursor.getString(1));
        temp.setChestSize(cursor.getDouble(2));
        temp.setWaistSize(cursor.getDouble(3));
        temp.setHipSize(cursor.getDouble(4));
        temp.setInseam(cursor.getDouble(5));
        }
        return temp;
    }

    public ArrayList<CloathingItem> getAllDataFilterGender(String gender){
        ArrayList<CloathingItem> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = ("SELECT * FROM sizeChart WHERE gender = " + "\"" + gender +"\"");
        Cursor cursor = db.rawQuery(query,null);
        //cursor.moveToFirst();
        while(cursor.moveToNext()){
            String dbBrand = cursor.getString(0);
            String dbGender = cursor.getString(1);
            String dbType = cursor.getString(2);
            String dbSize = cursor.getString(3);
            String dbChestMin = cursor.getString(4);
            String dbChestMax = cursor.getString(5);
            String dbWaistMin = cursor.getString(6);
            String dbWaistMax = cursor.getString(7);
            String dbHipsMin = cursor.getString(8);
            String dbHipsMax = cursor.getString(9);
            String dbInseam = cursor.getString(10);



            Log.d("From Database: ", "Items: " + dbBrand + dbType+ dbSize);

            CloathingItem item =
                    new CloathingItem(dbBrand,
                            dbGender,
                            dbType,
                            dbSize,
                            Double.parseDouble(dbChestMin),
                            Double.parseDouble(dbChestMax),
                            Double.parseDouble(dbWaistMin),
                            Double.parseDouble(dbWaistMax),
                            Double.parseDouble(dbHipsMin),
                            Double.parseDouble((dbHipsMax)),
                            Double.parseDouble(dbInseam));


            Log.d("From Database: ", "Items: " + item.toString());
            arrayList.add(item);
        }
        return arrayList;
    }

}
