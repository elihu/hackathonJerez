package com.example.senderosapp;

import java.io.File;

import com.example.conexiones.enviarFiltros;
import com.example.conexiones.enviarIncidencia;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class reportarIncidencia extends Activity{
	private EditText edittextTitulo;
	private EditText editextComentario;
	private Button enviar;
	private String titulo, comentario;
	private String ruta;
	private String[] datosRuta;
	private reportarIncidencia context;
	private Button foto;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.envio_incidencias);
		Bundle rutas = this.getIntent().getExtras();
        ruta = rutas.getString("Ruta");
        datosRuta = ruta.split(",");
        
		
		edittextTitulo = (EditText)findViewById(R.id.edittitulo);
		editextComentario = (EditText)findViewById(R.id.editdescripcion);
		enviar = (Button)findViewById(R.id.botonenviar);
		foto = (Button)findViewById(R.id.botonfoto);
		context = this;
		
		foto.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			      Uri output = Uri.fromFile(new File(""));
			      intent.putExtra("output", output);
			     
			      startActivityForResult(intent, 0);
			}
		});
		
		
		enviar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				comprobar();
			}

			private void comprobar() {
				// TODO Auto-generated method stub
				titulo = edittextTitulo.getText().toString();
				comentario = editextComentario.getText().toString();
				if(titulo.length() > 5 && titulo.length() < 100 && comentario.length() > 10 && comentario.length() < 200){
					enviarIncidencia incidencia = new enviarIncidencia();
					incidencia.inicializarValores(titulo, comentario, datosRuta[0], context, datosRuta);
					incidencia.execute();
				}
				else{
					Toast.makeText(context, "Campos demasiado cortos", 1000);
				}
			}
		});
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  super.onActivityResult(requestCode, resultCode, data);

		  if(resultCode !=Activity.RESULT_CANCELED){
		         if (requestCode == 0) {
		          Intent cropIntent = new Intent("com.android.camera.action.CROP");
		             //indicate image type and Uri
		             cropIntent.setDataAndType(Uri.fromFile(new File("")), "image/*");
		             //set crop properties
		             cropIntent.putExtra("crop", "true");
		             cropIntent.putExtra("output", Uri.fromFile(new File("")));
		             //start the activity - we handle returning
		             startActivityForResult(cropIntent, 1);
		         }
		         else if (requestCode== 1)
		         {
		          Intent in= new Intent(this, reportarIncidencia.class);
		         
		          startActivity(in);
		         }
		 }
	}

}
