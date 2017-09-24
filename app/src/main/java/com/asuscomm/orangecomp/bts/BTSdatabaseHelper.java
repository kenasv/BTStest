package com.asuscomm.orangecomp.bts;

/**
 * Created by kenasv on 22.09.2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

//
import android.widget.EditText;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ImageView;

class BTSdatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "btsbase"; // Имя базы данных
    private static final int DB_VERSION = 1; // Версия базы данных

    BTSdatabaseHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE PL (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NOMER TEXT, "
                + "ADRES TEXT, "
                + "IMAGE_TIP_ID INTEGER);");
        insertPL(db, "33-001", "Студенная", R.drawable.krovla);
        insertPL(db, "33-002", "Юбилейная", R.drawable.krovla);
        insertPL(db, "33-003", "Каманина", R.drawable.stolb);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
        private static void insertPL(SQLiteDatabase db, String nomer,
                String adres, int imagetipid) {
            // метод вставки в таблицу данных
            ContentValues PLValues = new ContentValues();
            PLValues.put("NOMER", nomer);
            PLValues.put("ADRES", adres);
            PLValues.put("IMAGE_TIP_ID INTEGER", imagetipid);
            db.insert("btsbase", null, PLValues);
        }


}
