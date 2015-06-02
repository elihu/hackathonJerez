package com.example.adapter;

import com.example.senderosapp.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RutaAdapter extends BaseAdapter {

	public ImageLoader imageLoader;
	public DisplayImageOptions options;
    private Activity context;
    private String[] ruta;
    private static int[] valoraciones = {0, 1, 2, 3};

    public RutaAdapter(Activity context, String[] ruta){
        super();
        this.context = context;
        this.ruta = ruta;
    }

	@Override
	public int getCount() {
		return ruta.length;
	}

	@Override
	public Object getItem(int pos) {
		return ruta[pos];
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		/*imageLoader = ImageLoader.getInstance();
	     options = new DisplayImageOptions.Builder()
	      .resetViewBeforeLoading(true)
	      .cacheInMemory(false)
	      .cacheOnDisk(true)
	      .imageScaleType(ImageScaleType.EXACTLY)
	      .bitmapConfig(Bitmap.Config.RGB_565)
	      .considerExifParams(true)
	      .build();*/
		ViewRuta view;
		String rutaActual[] = ruta[position].split(",");
		if(convertView == null){
			
			view = new ViewRuta();
			convertView = LayoutInflater.from(context).inflate(R.layout.listado_ruta, parent, false);
			view.nombre = (TextView) convertView.findViewById(R.id.nombre);
			view.nombre.setText(rutaActual[1]);
			view.longitud = (TextView) convertView.findViewById(R.id.longitud);
			view.longitud.setText(rutaActual[5]);
			view.dificultad = (TextView) convertView.findViewById(R.id.dificultad);
			view.dificultad.setText(rutaActual[6]);
			view.valoracion = (ImageView) convertView.findViewById(R.id.valoracionestrella);
			//view.valoracion.setText(rutaActual[1]);
			int parte_entera = 0;
			if(Integer.getInteger(rutaActual[7]) != null)
				parte_entera = Integer.getInteger(rutaActual[7]);
			  double parte_flotante= valoraciones[position]-parte_entera;
			  int restID= 0;
			 
			  if(parte_flotante<0.5)
			  {
			   restID= context.getResources().getIdentifier("estrella"+parte_entera+"0", "drawable", "com.example.senderosapp");

			  }else if(parte_flotante>0.5)
			  {
			   restID= context.getResources().getIdentifier("estrella"+(parte_entera+1)+"0", "drawable", "com.example.senderosapp");
			  }else
			  {
			   restID= context.getResources().getIdentifier("estrella"+parte_entera+"5", "drawable", "com.example.senderosapp");
			  }
			 
			  	/*indicator = (ProgressBar)findViewById(R.id.progressListaRuta);
				imageLoader.loadImage(rutaActual[7], options,new ImageLoadingListener(){


		        //Cuando la imagen haya terminado de cargar, que el indicador esté invisible y la imagen esté visible.
		        @Override
		        public void onLoadingComplete(String arg0, View arg1, Bitmap arg2) {
		            indicator.setVisibility(View.INVISIBLE);
		        }

				@Override
				public void onLoadingCancelled(String arg0, View arg1) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onLoadingStarted(String arg0, View arg1) {
					// TODO Auto-generated method stub
					
				}


		    });*/
			  
			  //Log.e("valoracionees", String.valueOf(restID)+ " " + parte_entera);
			  view.valoracion.setImageResource(restID);
			convertView.setTag(view);
		}
		else
			view = (ViewRuta) convertView.getTag();
		return convertView;
	}
		
		
		
	
	private ProgressBar findViewById(int progresslistaruta) {
		// TODO Auto-generated method stub
		return null;
	}




	private static class ViewRuta{
		TextView nombre;
		TextView longitud;
		TextView dificultad;
		ImageView valoracion;
	}
}