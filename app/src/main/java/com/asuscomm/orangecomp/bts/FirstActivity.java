package com.asuscomm.orangecomp.bts;

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


public class FirstActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    //объявляем нашу переменную как константу
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Intent intent = getIntent();
        //запрашиваем данные из интента
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        //вытаскиваем из интента информацию объекта message
        TextView messageView = (TextView) findViewById(R.id.message);
        // присватваем messageView информацию из message
        messageView.setText(messageText);
        //выводим информациб message




        TextView popa = (TextView) findViewById(R.id.popa);
        popa.setText("ggf");
        //int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_MESSAGE);

        //Создание курсора
        try {
            SQLiteOpenHelper btsdatabasehelper = new BTSdatabaseHelper(this);

            TextView nomerz = (TextView) findViewById(R.id.nomer);
            nomerz.setText("проверка создания базы данных");

            SQLiteDatabase db = btsdatabasehelper.getReadableDatabase();
            Cursor cursor = db.query("PL",
                    new String[]{"NOMER", "ADRES", "IMAGE_TIP_ID"},
                    "NOMER = ?",
                    new String[]{"33-001"},
                    null, null, null);

            //Переход к первой записи в курсоре
            if (cursor.moveToFirst()) {
//Получение данных напитка из курсора
                String nomerText = cursor.getString(0);
                String adresText = cursor.getString(1);
                int photoId = cursor.getInt(2);
//Заполнение названия напитка
                TextView nomer = (TextView) findViewById(R.id.nomer);
                nomer.setText(nomerText);
//Заполнение описания напитка
                TextView adres = (TextView) findViewById(R.id.adres);
                adres.setText(adresText);
//Заполнение изображения напитка
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nomerText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();


        }

    }
}