package com.example.conexiones;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
//Clase encargada de la conexion con nuestro servidor para el registro de usuarios
public class HttpJsonObject {
	private InputStream stream = null;
	private String resultado = "";
	public JSONObject getserverdata(ArrayList<NameValuePair> parametros, String urlwebserver){
		httppostconnect(parametros,urlwebserver); //conecta con la url especificada via http y envia una peticion POST
		if (stream != null){
			getpostresponse();
			return getjsonarray();
		}
		else
			return null;
	}
	private void httppostconnect(ArrayList<NameValuePair> parametros, String urlwebserver){
		try{
//Parametros para la conexion http
			final HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
			HttpClient httpclient = new DefaultHttpClient(httpParams);
			HttpPost httppost = new HttpPost(urlwebserver);
			httppost.setEntity(new UrlEncodedFormEntity(parametros));
//Ejecutamos la tarea con elcliente http. Se espera que se devuelva un mensaje JSON
//Para saber si se ha realizado con éxito la petición.
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			stream = entity.getContent();
		}catch(Exception e){}
	}
	public void getpostresponse(){ //Convierte de JSON a String
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			stream.close();
			resultado = sb.toString();
			Log.e("Resultado","Resultado : " + sb.toString());
		}catch(Exception e){}
	}
	public JSONObject getjsonarray(){ //Obtenemos los resultados en formato JSONObject
		try{
			JSONObject jArray;
			if(resultado.equals("false") || resultado.equals("null"))
				jArray = new JSONObject();
			else
				jArray = new JSONObject(resultado);
			return jArray;
		}
		catch(JSONException e){
			return null;
		}
	}
}