package com.asuscomm.orangecomp.bts;
// полное название моего приложения

import android.support.v7.app.AppCompatActivity;
//основная библиотека на которой строятся приложения на android в Android Studio. Нужна для панели управления

import android.os.Bundle;

import android.view.View;
//библиотека для кнопки

import android.content.Intent;
// библиотека для интента - вызов одной активности из другой

import android.widget.EditText;
// для использования EditText

public class MainActivity extends AppCompatActivity {
// наш основной класс Активности, который запускается при запуске при запуске приложения
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


public void button_find (View view){
    //метод вызываемый при щелчке на кнопку

    EditText messageView = (EditText)findViewById(R.id.message);
    String messageText = messageView.getText().toString();

    Intent intent = new Intent(this, FirstActivity.class);
    intent.putExtra(FirstActivity.EXTRA_MESSAGE, messageText);
    startActivity(intent);
    //запускаем активность из активности


    }
}
