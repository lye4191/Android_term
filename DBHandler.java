package com.example.user.myapp;
/*
참고 사이트 : http://ssscool.tistory.com/entry/
%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C%EC%8A%A4%ED%8A%9C%EB%94%94%EC%98%A4Android-Studio-
%EA%B2%BD%EB%9F%89-%EC%9E%84%EB%B2%A0%EB%94%94%EB%93%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4SQLite%EC%97%90%EC%8A%A4%ED%8A%9C%EC%97%98-%EB%9D%BC%EC%9D%B4%ED%8A%B8-
%ED%99%9C%EC%9A%A9%ED%95%98%EA%B8%B0-SQLite-Browser-DownLoad-SQlite-Device-DB-%ED%8C%8C%EC%9D%BC-%EA%B0%80%EC%A0%B8%EC%98%A4%EA%B8%B0-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-
%EC%98%88%EC%A0%9C-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%95%EC%A2%8C
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 2017-04-21.
 */

public class DBHandler {
    private DBHelper helper;
    private SQLiteDatabase db;

    private DBHandler(Context context){
        this.helper = new DBHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public static DBHandler open(Context context) throws SQLException{
        DBHandler handler = new DBHandler(context);
        return handler;
    }

    public void close() {helper.close(); }

    public long insert(String car_name){
        ContentValues values = new ContentValues();
        values.put("car_name", car_name);
        return db.insert("cars", null, values);
    }
    public Cursor select(int id) throws SQLException{
        Cursor cursor = db.query(true, "cars", new String[]{"_id","car_name"}, "_id"
        +"="+id,null,null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
