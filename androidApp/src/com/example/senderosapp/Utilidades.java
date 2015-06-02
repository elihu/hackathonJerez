package com.example.senderosapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utilidades {
	public static boolean existeConexion(Context context) {
	    ConnectivityManager conexion = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo infoConexion = conexion.getActiveNetworkInfo();
	    if (infoConexion != null && infoConexion.isConnected()) {
	        return true;
	    }
	    return false;
	}
}
