package com.example.tolet_board;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper4 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME4="officedetails.db";
    private static final String TABLE_NAME4="office_details";
    private static final String ID="id";
    //private static final String NAME="Name";
    private static final String OWNERNAME="Ownername";
    private static final String TITLE="Title";
    private static final String RENT="Rent";
    private static final String MONTH="Month";
    private static final String PHONE_NUMBER="Phone_number";
    //private static final String EMAIL="Email";
    // private static final String PASSWORD="Password";
    private static final String LOCATION="Location";
    private static final String DESCRIPTION="Description";
    private static final int VERSION_NUMBER4=9;
    private static final String CREATE_TABLE4= "CREATE TABLE "+TABLE_NAME4+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+OWNERNAME+" TEXT NOT NULL,"+TITLE+" TEXT NOT NULL,"+RENT+" TEXT NOT NULL,"+MONTH+" TEXT NOT NULL,"+PHONE_NUMBER+" TEXT NOT NULL,"+LOCATION+" TEXT NOT NULL,"+DESCRIPTION+" TEXT NOT NULL);";

    private static final String DROP_TABLE4 ="DROP TABLE IF EXISTS "+TABLE_NAME4;

    private Context context;
    public DatabaseHelper4( Context context) {
        super(context, DATABASE_NAME4, null, VERSION_NUMBER4);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE4);
            Toast.makeText(context,"onCreate is called", Toast.LENGTH_LONG).show();
        }
        catch(Exception e) {
            Toast.makeText(context,"Exception:"+e, Toast.LENGTH_LONG).show();

        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{
            Toast.makeText(context,"onUpgrade is called", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE4);
            onCreate(sqLiteDatabase);

        }
        catch(Exception e) {
            Toast.makeText(context,"Exception:"+e, Toast.LENGTH_LONG).show();

        }

    }
    public long saveData(String Ownername,String Title, String Rent, String Month,String phone_Number, String location,String Description)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(OWNERNAME,Ownername);

        contentValues.put(TITLE,Title);
        contentValues.put(RENT,Rent);
        contentValues.put(MONTH,Month);

        contentValues.put(PHONE_NUMBER,phone_Number);
        contentValues.put(LOCATION,location);
        contentValues.put(DESCRIPTION,Description);
        long rowId= sqLiteDatabase.insert(TABLE_NAME4,null,contentValues);
        return rowId;
    }

    public Cursor showAllData()
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME4,null);
        return cursor;
    }
}
