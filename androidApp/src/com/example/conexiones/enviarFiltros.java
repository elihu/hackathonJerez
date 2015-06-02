package com.example.conexiones;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.example.senderosapp.Utilidades;
import com.example.senderosapp.rutas;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;


public class enviarFiltros extends AsyncTask<Void,Void,String>{
	private HttpJsonObject peticionPostServidor = new HttpJsonObject();
	private String municipio, dificultad, valoracion, resultado, tag;
	int distancia;
	private Context context;

	public void inicializarValores(String municipio, int distancia, String dificultad, String valoracion, Context context){
		this.municipio = municipio;
		this.distancia = distancia;
		this.dificultad = dificultad;
		this.valoracion = valoracion;
		this.context = context;
		tag = "consultaRuta";
  }

	@Override
	protected String doInBackground(Void... params) {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("Municipio", municipio));
		nameValuePairs.add(new BasicNameValuePair("Distancia", Integer.toString(distancia)));
		nameValuePairs.add(new BasicNameValuePair("Dificultad", dificultad));
		nameValuePairs.add(new BasicNameValuePair("Valoracion", valoracion));
		nameValuePairs.add(new BasicNameValuePair("tag", tag));
		JSONObject jdata;
		//do{
	          jdata = peticionPostServidor.getserverdata(nameValuePairs, "http://192.168.15.142/php/index.php");
	       //}while(!Utilidades.existeConexion(context));
		System.out.println(jdata);
		try {
			resultado = jdata.getString("consulta");
			if(resultado!=null)
				System.out.println(resultado);
			else
				System.out.println("HOLA");
		} catch (Exception e) {}
		return resultado;
	}
	@Override
	protected void onPostExecute(String result) {
		if(resultado != ""){
			 Intent datos = new Intent();
			 datos.putExtra("Rutas", resultado);
			 datos.setClass(context, rutas.class);
			 context.startActivity(datos);
		}
	}
}