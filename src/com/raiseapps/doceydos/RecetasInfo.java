package com.raiseapps.doceydos;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class RecetasInfo extends Activity {
	
	WebView wvRecetasInfo;
	//String textHtml;
	String url = "http://www.12y2.com/index.php?option=com_content&view=article&id=5953:aros-de-cebolla-tempura&catid=45:receta-del-dia&Itemid=109";
	ImageButton sigiente;
	ImageButton anterior;
	String textHtml;
	String[] textArr = new String[20];
	int PaginaActual=0;
	
	ImageButton ibPodcast;
	ImageButton ibRecetas;
	ImageButton ibEnvivo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recetas_info_activity);
		
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
		//question.setText(gotBread);
		
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
		
		url = "http://12y2.com"+textArr[PaginaActual];
		
		try {
			//textHtml = new GetHtmlEj().getInternetData2(new URI("http://www.12y2.com/index.php?option=com_content&view=article&id=5953:aros-de-cebolla-tempura&catid=45:receta-del-dia&Itemid=109"));
			Bundle gotBasket = getIntent().getExtras();//se cogen los extras de la actividad anterior 
			url = "http://12y2.com" + gotBasket.getString("key");//se toma el string que manda la otra actividad
			PaginaActual = gotBasket.getInt("KeyAct");
			Log.i("basket", url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sigiente = (ImageButton) findViewById(R.id.ibSiguiente);
		anterior = (ImageButton) findViewById(R.id.ibAnterior);
		sigiente.setOnClickListener(l);
		anterior.setOnClickListener(l);
		
		wvRecetasInfo = (WebView) findViewById(R.id.wbRecetasInfo);
		//wvRecetasInfo.setWebViewClient(new visorClienteWeb());
		//wvRecetasInfo.getSettings().setJavaScriptEnabled(true);
		wvRecetasInfo.getSettings().setPluginsEnabled(true);
		wvRecetasInfo.getSettings().setLoadWithOverviewMode(true);
		//wvRecetasInfo.getSettings().setUseWideViewPort(true);
		
		
		//textHtml = "<!DOCTYPE html><html ><head></head><body> "+textHtml+" </body></html>";
		
//			try {
//			wvRecetasInfo.loadData(URLEncoder.encode(textHtml,"utf-8").replaceAll("\\+"," "),
//					"text/html", "utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		wvRecetasInfo.loadUrl(url);
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
	
	View.OnClickListener l = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent openNextActivity; 
			Bundle embase = new Bundle();
			
			if(v == sigiente){
				if(PaginaActual<14)
					PaginaActual +=2;
				
				embase.putString("key", textArr[PaginaActual]);
				embase.putInt("KeyAct", PaginaActual);
				openNextActivity = new Intent(RecetasInfo.this, RecetasInfo.class);
				openNextActivity.putExtras(embase);
				startActivity(openNextActivity); 
			}if(v == anterior){
				if(PaginaActual>0)
					PaginaActual -=2;
				embase.putString("key", textArr[PaginaActual]);
				embase.putInt("KeyAct", PaginaActual);
				openNextActivity = new Intent(RecetasInfo.this, RecetasInfo.class);
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
		getMenuInflater().inflate(R.menu.recetas_info_activity, menu);
		return true;
	}

}
