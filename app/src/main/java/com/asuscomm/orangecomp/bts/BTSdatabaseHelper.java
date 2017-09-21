package com.asuscomm.orangecomp.bts;

/**
 * Created by kenasv on 22.09.2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class BTSdatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "btsbase"; // Имя базы данных
    private static final int DB_VERSION = 1; // Версия базы данных

    BTSdatabaseHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION)
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NOMER TEXT, "
                + "ADRES TEXT, "
                + "IMAGE_TIP_ID INTEGER);");
        insertDrink(db, "33-001", "Студенная", R.drawable.krovla);
        insertDrink(db, "33-002", "Юбилейная", R.drawable.krovla);
        insertDrink(db, "33-003", "Каманина", R.drawable.stolb);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
