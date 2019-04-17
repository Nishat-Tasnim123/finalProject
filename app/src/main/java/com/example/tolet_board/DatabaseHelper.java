package com.example.tolet_board;

import android.content.ContentValues;
import android.content.Context;
import android.content.RestrictionEntry;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="userdetails.db";
    private static final String TABLE_NAME="user_details";
    private static final String ID="id";
    private static final String NAME="Name";
    private static final String CONTACT_NUMBER="Contact_number";
    private static final String EMAIL="Email";
    private static final String PASSWORD="Password";
    private static final String CITY="City";

    private static final int VERSION_NUMBER=1;
    private Context context;

    private static final String CREATE_TABLE= "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+NAME+" VARCHAR(255) NOT NULL,"+CONTACT_NUMBER+" TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL,"+CITY+" TEXT NOT NULL);";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
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
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }
        catch(Exception e) {
            Toast.makeText(context,"Exception:"+e, Toast.LENGTH_LONG).show();

        }

    }
    public long saveData(UserDetails userDetails)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,userDetails.getname());
        contentValues.put(CONTACT_NUMBER,userDetails.getConNo());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(PASSWORD,userDetails.getPw());
        contentValues.put(CITY,userDetails.getCity());

        long rowId= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }

    public Boolean findPassword(String uname, String pass)
    {
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT*FROM "+TABLE_NAME,null);
        Boolean result=false;
        if(cursor.getCount()==0)
        {
            Toast.makeText(context,"No data is found",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                String username=cursor.getString(1);
                String password=cursor.getString(4);

                if(username.equals(uname)&& password.equals(pass))
                {
                    result=true;
                    break;
                }
            }
        }
        return result;
    }
    /*public Cursor showAllData()
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor1=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor1;
    }*/
}
