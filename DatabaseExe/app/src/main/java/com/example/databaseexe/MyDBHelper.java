package com.example.databaseexe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT = "contact";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_no";


    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //CREATE TABLE contact (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,phone_no TEXT);
        db.execSQL("CREATE TABLE "+TABLE_CONTACT+ "("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_NAME+" TEXT,"+KEY_PH_NO+" TEXT"+")");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACT);
        onCreate(db);

    }
    public void addContact(String name, String phone_no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_PH_NO,phone_no);
        db.insert(TABLE_CONTACT,null,values);
    }
    public ArrayList<ContactModel> getContact(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_CONTACT,null);
        ArrayList<ContactModel> arrContacts = new ArrayList<>();
        while (cursor.moveToNext()){
            ContactModel model = new ContactModel();
            model.id=cursor.getInt(0);
            model.name=cursor.getString(1);
            model.phone_no = cursor.getString(2);

            arrContacts.add(model);
        }
        return arrContacts;
    }
    public void updateContact(ContactModel contactModel){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_PH_NO,contactModel.phone_no);

        database.update(TABLE_CONTACT,cv,KEY_ID +" = "+contactModel.id,null);

    }
    public void deleteContact(int id){

        SQLiteDatabase db = this.getWritableDatabase();



        db.delete(TABLE_CONTACT,KEY_ID+" = ? ",new String[]{String.valueOf(id)});

    }


}
