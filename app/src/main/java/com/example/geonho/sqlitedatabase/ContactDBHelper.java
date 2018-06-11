package com.example.geonho.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//SQLiteOpenHelper를 상속한 Helper 클래스 정의
public class ContactDBHelper extends SQLiteOpenHelper{

    public static final int DB_VERSION = 1;
    public static final String DBFILE_CONTACT = "contact.db";

    public ContactDBHelper(Context context){
        super(context,DBFILE_CONTACT,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContactDBCtrct.SQL_CREATE_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(ContactDBCtrct.SQL_CREATE_TBL);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade(db, oldVersion, newVersion);
    }

}
