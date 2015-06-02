package com.example.senderosapp;

import com.example.adapter.ArrayAdapterWithIcon;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class rutaElegida extends Activity{
	private String ruta;
	private String[] datosRuta;
	private TextView textNombre;
	private ImageView imageRuta;
	private TextView textLongitud;
	private TextView textDuracion;
	private TextView textPermiso;
	private TextView textDificultad;
	private ImageView imageValoracion;
	private AlertDialog dialog;
	ArrayAdapterWithIcon adapter;
	final String[] option = new String[] { "0", "0,5", "1", "1,5", "2", "2,5", "3" };
	final Integer[] icons = new Integer[] {R.drawable.estrella00, R.drawable.estrella05, R.drawable.estrella10, R.drawable.estrella15, R.drawable.estrella20, R.drawable.estrella25, R.drawable.estrella30};
	public static rutaElegida context;
	private double puntuacion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.descripcion_ruta);
		
        Bundle rutas = this.getIntent().getExtras();
        ruta = rutas.getString("ruta");
        datosRuta = ruta.split(",");
        
        Button botonvaloracion= (Button) findViewById(R.id.botonvaloracion);
        textNombre = (TextView)findViewById(R.id.nombre);
        textNombre.setText(datosRuta[1]);
        imageRuta = (ImageView)findViewById(R.id.imagenRuta);
        imageRuta.setImageResource(this.getResources().getIdentifier("sendero", "drawable", "com.example.senderosapp"));

        textLongitud = (TextView)findViewById(R.id.longitud);
        textLongitud.setText("Longitud: "+datosRuta[5]);
        textDuracion = (TextView)findViewById(R.id.duracion);
        textDuracion.setText("Duración: "+ datosRuta[3]);
        textPermiso = (TextView)findViewById(R.id.permiso);
        textPermiso.setText("Permiso: "+ datosRuta[4]);
        textDificultad = (TextView)findViewById(R.id.dificultad);
        textDificultad.setText("Dificultad: "+datosRuta[6]);
        
        Button valoracion = (Button)findViewById(R.id.botonvaloracion);
		valoracion.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				
			}
		});
		
		Button reportar = (Button)findViewById(R.id.botonreportar);
		reportar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				Intent datos = new Intent();
				 datos.putExtra("Ruta", ruta);
				 datos.setClass(context, reportarIncidencia.class);
				 context.startActivity(datos);
				 finish();
			}
		});
		

		Button incidencias = (Button)findViewById(R.id.botonvisualizar);
		incidencias.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				//
			}
		});
		
		final String[] option = new String[] { "0", "0,5", "1", "1,5", "2", "2,5", "3" };
		final Integer[] icons = new Integer[] {R.drawable.estrella00, R.drawable.estrella05, R.drawable.estrella10, R.drawable.estrella15, R.drawable.estrella20, R.drawable.estrella25, R.drawable.estrella30 };
		 
		  AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 
		       
		  ListAdapter adap = new ArrayAdapterWithIcon(this, option, icons);

		  builder.setTitle("Puntuación");
		  builder.setAdapter(adap, new DialogInterface.OnClickListener() {
		 
		    public void onClick(DialogInterface dialog, int posicion) {
		          // TODO Auto-generated method stub
		     switch (posicion)
		     {
		      case 0:
		       puntuacion=0;
		       break;
		      case 1:
		       puntuacion=0.5;
		       break;
		      case 2:
		       puntuacion=1;
		       break;
		      case 3:
		       puntuacion=1.5;
		       break;
		      case 4:
		       puntuacion=2;
		       break;
		      case 5:
		       puntuacion=2.5;
		       break;
		      case 6:
		       puntuacion=3;
		       break;
		    default: break;
		     
		     }
		    }
		  });
		  dialog= builder.create();

		botonvaloracion.setOnClickListener(new valorarImagen());
		context = this;
		
	}
	
	private class valorarImagen implements View.OnClickListener
	 {

	  @Override
	  public void onClick(View v) {
	   // TODO Auto-generated method stub
	   dialog.show();
	  }
	 
	 }

}
