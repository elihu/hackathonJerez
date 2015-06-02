package com.example.senderosapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Context cont = this;
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent cambio_actividad = new Intent();
                    cambio_actividad.setClass(cont, com.example.senderosapp.menu.class);
                    startActivity(cambio_actividad);
                    finish();
                }                
            }
        };
        timer.start();
    }

}
