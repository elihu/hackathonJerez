package com.example.conexiones;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.senderosapp.rutas;

public class actualizarPuntuacion extends AsyncTask<Void,Void,String>{
	private HttpJsonObject peticionPostServidor = new HttpJsonObject();
	double valoracion;
	private Context context;
	private String tag;
	private int id;

	public void inicializarValores(double valoracion, Context context, int id){
		this.valoracion = valoracion;
		this.context = context;
		tag = "valoracion";
		this.id = id;
  }

	@Override
	protected String doInBackground(Void... params) {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("Valoracion", Double.toString(valoracion)));
		nameValuePairs.add(new BasicNameValuePair("tag", tag));
		nameValuePairs.add(new BasicNameValuePair("Id", Integer.toString(id)));
		JSONObject jdata;
		//do{
	          jdata = peticionPostServidor.getserverdata(nameValuePairs, "192.168.15.142/php/index.php");
	       //}while(!Utilidades.existeConexion(context));
		System.out.println(jdata);
		/*try {
			/*resultado = jdata.getString("consulta");
			if(resultado!=null)
				System.out.println(resultado);
			else
				System.out.println("HOLA");
		} catch (Exception e) {}*/
		return "";
	}
	@Override
	protected void onPostExecute(String result) {
		if(result != ""){
			 Intent datos = new Intent();
			 datos.putExtra("Rutas", result);
			 datos.setClass(context, rutas.class);
			 context.startActivity(datos);
		}
	}
}