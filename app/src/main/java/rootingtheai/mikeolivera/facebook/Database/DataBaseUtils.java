package rootingtheai.mikeolivera.facebook.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import rootingtheai.mikeolivera.facebook.Models.Account;

/**
 * Created by mikes on 19-Sep.
 */

public class DataBaseUtils {

    private Database DB;
    private SQLiteDatabase database;

    public DataBaseUtils(Context CTT){
        DB=new Database(CTT);
        database=DB.getWritableDatabase();
    }


    public boolean add_user(String username,String password){

        try {
            ContentValues CV = new ContentValues();
            CV.put(SQL_STATEMENTS.a_user, username);
            CV.put(SQL_STATEMENTS.a_pass, password);
            CV.put(SQL_STATEMENTS.a_date, getDate());
            database.insert(SQL_STATEMENTS.t_accounts, null, CV);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Account> get_list(){
        Cursor mCursor =  database.rawQuery(SQL_STATEMENTS.get_reg,null);
        List<Account> LISTA = new ArrayList<Account>();
        for(mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
            Account cuenta = new Account(mCursor.getInt(0),mCursor.getString(1),mCursor.getString(2),mCursor.getString(3));
            LISTA.add(cuenta);
        }
        return LISTA;
    }

    private String getDate(){
        DateFormat dfDate = new SimpleDateFormat("yyyy/MM/dd");
        String date=dfDate.format(Calendar.getInstance().getTime());
        DateFormat dfTime = new SimpleDateFormat("HH:mm");
        String time = dfTime.format(Calendar.getInstance().getTime());
        return date + " " + time;
    }

}
