package com.example.senderosapp;

import com.example.conexiones.enviarFiltros;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class menu extends Activity {
	private static final String[] municipios = new String[] {"Alcala de los Gazules", "Alcala del valle", "Algar","Algeciras",
		"Algodonales", "Arcos de la Frontera", "Barbate","Benalup", "Benaocaz", "Cadiz",
		"Castellar de la Frontera","Chiclana de la Frontera", "Conil de la Frontera","El Bosque",
		"El Gastor", "El Puerto de Santa Maria", "Espera","Grazalema", "Jerez de la Frontera", 
		"Jimenza de la Frontera", "La Linea de la Concepcion", "Los Barrios", "Medina Sidonia", "Olvera",
		"Paterna de Rivera", "Puerto Real", "Puerto Serrano", "Prado del Rey", "Rota", "San Jose del Valle", "San Roque",
		"Sanlucar de Barrameda", "San Fernando", "Setenil", "Tarifa", "Torrealhaquime", "Ubrique", "Vejer de la Frontera", 
		"Villaluenga del Rosario", "Villamartin", "Zahara"};
    private static final Integer[] distancia = new Integer[]{15000, 13000, 11000, 9000, 7000, 5000, 3000, 1000};
    private static final String[] dificultad = new String[]{"Baja", "Media", "Alta"};
    private static final String[] valoracion = new String[]{"0", "0.5", "1", "1.5", "2","2.5", "3"};
    private String municipioVar = "";
    private int longitudVar = 0;
    private String dificultadVar = "";
    private String valoracionVar = "";
    private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		Spinner spinnerMunicipio = (Spinner) findViewById(R.id.MunicipioSpinner);
		spinnerMunicipio.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, municipios));
		spinnerMunicipio.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					municipioVar = municipios[arg2];
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
	        });
		
		Spinner spinnerLongitud = (Spinner) findViewById(R.id.LongitudSpinner);
		spinnerLongitud.setAdapter(new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, distancia));
		spinnerLongitud.setOnItemSelectedListener(new OnItemSelectedListener() {
			 
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				longitudVar = distancia[arg2];
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	        });
		
		Spinner spinnerDificultad = (Spinner) findViewById(R.id.DificultadSpinner);
		spinnerDificultad.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dificultad));
		spinnerDificultad.setOnItemSelectedListener(new OnItemSelectedListener() {
			 
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				dificultadVar = dificultad[arg2];
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	        });
		
		Spinner spinnerValoracion = (Spinner) findViewById(R.id.ValoracionSpinner);
		spinnerValoracion.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valoracion));
		spinnerValoracion.setOnItemSelectedListener(new OnItemSelectedListener() {
			 
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				valoracionVar = valoracion[arg2];
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	        });
		context = this;
		Button buscar = (Button)findViewById(R.id.searchPeople);
		buscar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				enviarFiltros filtros = new enviarFiltros();
                filtros.inicializarValores(municipioVar, longitudVar, dificultadVar, valoracionVar, context);
                filtros.execute();
				
			}
		});
		
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
