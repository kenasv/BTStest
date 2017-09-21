package com.asuscomm.orangecomp.bts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;

public class FirstActivity extends AppCompatActivity {

    private BTSdatabaseHelper btsdatabasehelper = new BTSdatabaseHelper();
    //ссылаемся на класс BTSdatabaseHelper по работе с базой данных
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
        TextView messageView = (TextView)findViewById(R.id.message);
        // присватваем messageView информацию из message
        messageView.setText(messageText);
        //выводим информациб message
    }





}
