package com.example.project;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table user(Email TEXT primary key,Password TEXT ,Firstname TEXT,Lastname TEXT,Passport TEXT,Nationality TEXT,Birthdate TEXT,Phone TEXT,Confirmpass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists user");
    }

    public Boolean insertData(String email, String password ,String firstname ,String lastname,String passport,String nationality,String birthdate,String phone,String confirmpass){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Email", email);
        contentValues.put("Password", password);
        contentValues.put("Firstname", firstname);
        contentValues.put("Lastname", lastname);
        contentValues.put("Passport", passport);
        contentValues.put("Nationality", nationality);
        contentValues.put("Birthdate", birthdate);
        contentValues.put("Phone", phone);
        contentValues.put("Confirmpass", confirmpass);
        long result = MyDB.insert("user", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkemail(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword(String email, String password ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where email = ? and password = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
    public String printfirstname(String firstname){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where firstname = ? ", new String[] {firstname});
        return firstname;
    }
    public String printlastname(String lastname){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where lastname = ? ", new String[] {lastname});
        return lastname;
    }
}