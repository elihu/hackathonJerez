package com.example.conexiones;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.senderosapp.rutaElegida;
import com.example.senderosapp.rutas;

public class enviarIncidencia extends AsyncTask<Void,Void,Void>{
	private HttpJsonObject peticionPostServidor = new HttpJsonObject();
	private String titulo, descripcion, foto, idsendero;
	private Context context;
	private String[] rutaPadre;

	public void inicializarValores(String titulo, String descripcion, String idsendero, Context context, String[] rutaPadre){
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.idsendero = idsendero;
		this.context = context;
		this.rutaPadre = rutaPadre;
  }

	@Override
	protected Void doInBackground(Void... params) {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("Titulo", titulo));
		nameValuePairs.add(new BasicNameValuePair("Descripcion", descripcion));
		nameValuePairs.add(new BasicNameValuePair("IdSendero", idsendero));
		nameValuePairs.add(new BasicNameValuePair("tag", "reportarIncidencia"));
		JSONObject jdata;
		//do{
	          jdata = peticionPostServidor.getserverdata(nameValuePairs, "192.168.15.142/php/index.php");
	       //}while(!Utilidades.existeConexion(context));
		/*System.out.println(jdata);
		try {
			resultado = jdata.getString("consulta");
			if(resultado!=null)
				System.out.println(resultado);
			else
				System.out.println("HOLA");
		} catch (Exception e) {}
		return resultado;*/
			return null;
	}
	@Override
	protected void onPostExecute(Void result) {
		 Intent datos = new Intent();
		 String concatena = rutaPadre[0];
		 for(int i = 1; i < rutaPadre.length;i++)
			 concatena += ","+rutaPadre[i];
	     datos.putExtra("Rutas", concatena);
	     datos.setClass(context, rutaElegida.class);
		 context.startActivity(datos);
	}

}
