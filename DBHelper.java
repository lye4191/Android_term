package com.example.user.myapp;
/* ppt 참고 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context, String name, SQLiteDatabase,
                    SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table if not exists student("
                + "_id integer primary key autoincrement, "
                + "name text,"
                + "age integer, "
                + "address text);";

        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String sql = "drop table if exists students";
        db.execSQL(sql);

        onCreate(db);
    }
}