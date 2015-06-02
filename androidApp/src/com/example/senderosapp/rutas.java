package com.example.senderosapp;

import com.example.adapter.RutaAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class rutas extends Activity{
	private String rutasFiltradas;
	private String[] rutasSeparadas;
	private ListView listview;
	private RutaAdapter adapterLista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_rutas);
		
        Bundle rutas = this.getIntent().getExtras();
        rutasFiltradas = rutas.getString("Rutas");
        formatearRutas();
        
        listview = (ListView)findViewById(R.id.ListaRutas);
        adapterLista = new RutaAdapter(this, rutasSeparadas);
		listview.setAdapter(adapterLista);

		listview.setOnItemClickListener(new OnItemClickListener(){
				public void onItemClick(AdapterView<?> adapter, View view, int posicion, long id) {
					Intent cambio_actividad = new Intent();
					cambio_actividad.putExtra("ruta", rutasSeparadas[posicion]);
					cambio_actividad.setClass(getApplicationContext(), rutaElegida.class);
					startActivity(cambio_actividad);
					finish();
				}
					
		});
	}

	private void formatearRutas() {
		// TODO Auto-generated method stub
		if(rutasFiltradas.contains("-"))
		  rutasSeparadas = rutasFiltradas.split("-");
	}
}
