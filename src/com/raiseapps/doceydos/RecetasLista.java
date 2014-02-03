package com.raiseapps.doceydos;

import java.net.URI;
import java.net.URISyntaxException;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecetasLista extends Activity {
	
	ImageButton lista1;
	ImageButton lista2;
	ImageButton lista3;
	ImageButton lista4;
	ImageButton lista5;
	ImageButton lista6;
	ImageButton lista7;
	ImageButton lista8;
	TextView txtLista1;
	TextView txtLista2;
	TextView txtLista3;
	TextView txtLista4;
	TextView txtLista5;
	TextView txtLista6;
	TextView txtLista7;
	TextView txtLista8;
	String textHtml;
	String[] textArr = new String[20];
	TextView TextoPlano1; 
	TextView TextoPlano2;
	TextView TextoPlano3; 
	TextView TextoPlano4; 
	TextView TextoPlano5;
	TextView TextoPlano6; 
	TextView TextoPlano7; 
	TextView TextoPlano8;
	
	ImageButton ibPodcast;
	ImageButton ibRecetas;
	ImageButton ibEnvivo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recetas_lista_activity);
		
		ibPodcast = (ImageButton)findViewById(R.id.ibPodcast);
		ibRecetas = (ImageButton)findViewById(R.id.ibRecetas);
		ibEnvivo = (ImageButton)findViewById(R.id.ibEnvivo);
		ibPodcast.setOnClickListener(ibMenuOnClickListener);
		ibRecetas.setOnClickListener(ibMenuOnClickListener);
		ibEnvivo.setOnClickListener(ibMenuOnClickListener);
		
		try {
			textHtml = new GetHtmlEj().getInternetData3(new URI("http://www.12y2.com/index.php?option=com_content&view=category&id=45&Itemid=109"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Log.i("OBJET", textHtml);
		
		textArr = textHtml.split(System.getProperty("line.separator"));
		
		for(int i=0; i<textArr.length; i++){
			Log.i("ARR", textArr[i]+" "+i);
			textArr[i] = textArr[i].substring(11, textArr[i].length()-2);
			i++;
			if(textArr[i].length()>= 23+4){
				textArr[i] = textArr[i].substring(1, 23);
			}else{
				textArr[i] = textArr[i].substring(1, textArr[i].length()-4);
			}
			
		}
		
		TextoPlano1 = (TextView) findViewById(R.id.textoPlano1);
		TextoPlano1.setText(textArr[1]);
		TextoPlano2 = (TextView) findViewById(R.id.textoPlano2);
		TextoPlano2.setText(textArr[3]);
		TextoPlano3 = (TextView) findViewById(R.id.textoPlano3);
		TextoPlano3.setText(textArr[5]);
		TextoPlano4 = (TextView) findViewById(R.id.textoPlano4);
		TextoPlano4.setText(textArr[7]);
		TextoPlano5 = (TextView) findViewById(R.id.textoPlano5);
		TextoPlano5.setText(textArr[9]);
		TextoPlano6 = (TextView) findViewById(R.id.textoPlano6);
		TextoPlano6.setText(textArr[11]);
		TextoPlano7 = (TextView) findViewById(R.id.textoPlano7);
		TextoPlano7.setText(textArr[13]);
		TextoPlano8 = (TextView) findViewById(R.id.textoPlano8);
		TextoPlano8.setText(textArr[15]);
		
		
		
		
		lista1 = (ImageButton) (findViewById(R.id.ibLista1));
		lista2 = (ImageButton) (findViewById(R.id.ibLista2));
		lista3 = (ImageButton) (findViewById(R.id.ibLista3));
		lista4 = (ImageButton) (findViewById(R.id.ibLista4));
		lista5 = (ImageButton) (findViewById(R.id.ibLista5));
		lista6 = (ImageButton) (findViewById(R.id.ibLista6));
		lista7 = (ImageButton) (findViewById(R.id.ibLista7));
		lista8 = (ImageButton) (findViewById(R.id.ibLista8));
		lista1.setOnClickListener(lisaOnClickListener);
		lista2.setOnClickListener(lisaOnClickListener);
		lista3.setOnClickListener(lisaOnClickListener);
		lista4.setOnClickListener(lisaOnClickListener);
		lista5.setOnClickListener(lisaOnClickListener);
		lista6.setOnClickListener(lisaOnClickListener);
		lista7.setOnClickListener(lisaOnClickListener);
		lista8.setOnClickListener(lisaOnClickListener);
//		for(int i =0; i<textHtml.length;i++){
//			Log.i("Prueba", textHtml[i]);
//		}
		
	}
	
	View.OnClickListener ibMenuOnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent openNextActivity; 
			if(v == ibPodcast){
				openNextActivity = new Intent("com.riseapp.doceydos.PODCAST");
				startActivity(openNextActivity); 
			}if(v == ibRecetas){
				openNextActivity = new Intent("com.riseapp.doceydos.RECETAS");
				startActivity(openNextActivity); 
			}if(v == ibEnvivo){
				openNextActivity = new Intent("com.riseapp.doceydos.MENUINICIAL");
				startActivity(openNextActivity); 
			}
		}
	};
	
	View.OnClickListener lisaOnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent openNextActivity; 
			Bundle embase = new Bundle();
			if(v == lista1){
				
				
				embase.putString("key", textArr[0]);
				openNextActivity = new Intent(RecetasLista.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}if(v == lista2){
				embase.putString("key", textArr[2]);
				openNextActivity = new Intent(RecetasLista.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}if(v == lista3){
				embase.putString("key", textArr[4]);
				openNextActivity = new Intent(RecetasLista.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}if(v == lista4){
				embase.putString("key", textArr[6]);
				openNextActivity = new Intent(RecetasLista.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}if(v == lista5){
				embase.putString("key", textArr[8]);
				openNextActivity = new Intent(RecetasLista.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}if(v == lista6){
				embase.putString("key", textArr[10]);
				openNextActivity = new Intent(RecetasLista.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}if(v == lista7){
				embase.putString("key", textArr[12]);
				openNextActivity = new Intent(RecetasLista.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}if(v == lista8){
				embase.putString("key", textArr[14]);
				openNextActivity = new Intent(RecetasLista.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}
		}
	};
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
//		numeroFragment = numeroFragmentAnterior;
//		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recetas_lista_activity, menu);
		return true;
	}

}
