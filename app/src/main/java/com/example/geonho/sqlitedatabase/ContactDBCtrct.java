package com.example.geonho.sqlitedatabase;
//데이터베이스 Contact를 위한 계약 클래스.
public class ContactDBCtrct {

    private  ContactDBCtrct(){};

    public static final String TBL_CONTACT = "CONTACT_T";
    public static final String COL_NO = "NO";
    public static final String COL_NAME ="NAME";
    public static final String COL_PHONE = "PHONE";
    public static final String COL_OVER20 = "OVER20";

    //CREATE TABLE IF NOT EXISTS CONTACT_T (NO INTEGER NOT NULL, NAME TEXT, PHONE TEXT, OVER20 INTEGER)
    public static final String SQL_CREATE_TBL = "CREATE TABLE IF NOT EXISTS "+TBL_CONTACT+" "+
            "("+
                COL_NO + " INTEGER NOT NULL" + ", "+
                COL_NAME + " TEXT" + ", "+
                COL_PHONE + " TEXT"+ ", "+
                COL_OVER20 + " INTEGER" +
            ")";

    //DROP TABLE IF EXISTS CONTACT_T
    public static final String SQL_DROP_TBL = "DROP TABLE IF EXISTS " + TBL_CONTACT;

    //SELECT * FROM CONTACT_T
    public static final String SQL_SELECT = "SELECT * FROM " + TBL_CONTACT;

    //INSERT OR REPLACE INTO CONTACT_T (NO, NAME, PHONE, OVER20) VALUES (X, X, X, X)
    public static final String SQL_INSERT = "INSERT OR REPLACE INTO " + TBL_CONTACT + " " +
            "(" + COL_NO +", " + COL_NAME + ", " + COL_PHONE + ", " +COL_OVER20 + ") VALUES ";

    //DELETE FROM CONTACT_T
    public static final String SQL_DELETE = "DELETE FROM " + TBL_CONTACT;
}
