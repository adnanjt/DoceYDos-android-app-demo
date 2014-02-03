package com.raiseapps.doceydos;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import com.raiseapps.doceydos.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

public class Podcast extends Activity {

	WebView wvPodcast;
	//String myHTML;
	String textHtml;
	
	ImageButton ibPodcast;
	ImageButton ibRecetas;
	ImageButton ibEnvivo;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.podcast_activity);
		
		ibPodcast = (ImageButton)findViewById(R.id.ibPodcast);
		ibRecetas = (ImageButton)findViewById(R.id.ibRecetas);
		ibEnvivo = (ImageButton)findViewById(R.id.ibEnvivo);
		ibPodcast.setOnClickListener(ibMenuOnClickListener);
		ibRecetas.setOnClickListener(ibMenuOnClickListener);
		ibEnvivo.setOnClickListener(ibMenuOnClickListener);
		
		try {
			textHtml = new GetHtmlEj().getInternetData(new URI("http://www.12y2.com/index.php?option=com_content&view=article&id=224&Itemid=111"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wvPodcast = (WebView) findViewById(R.id.wbPodcast);
		wvPodcast.setWebViewClient(new visorClienteWeb());
		wvPodcast.getSettings().setJavaScriptEnabled(true);
		wvPodcast.getSettings().setPluginsEnabled(true);
		//wvPodcast.getSettings().setPluginState(WebSettings.PluginState.ON);
		wvPodcast.getSettings().setLoadWithOverviewMode(true);
		wvPodcast.getSettings().setUseWideViewPort(true);
		
		//wvPodcast.loadUrl("http://www.12y2.com/index.php?option=com_content&view=article&id=224&Itemid=111");
		
//		try {
//			wvPodcast.loadUrl("http://www.12y2.com/podcast//12y2-Edicion-10-Ene-2013.mp3");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		
		/*
		wvNoticias.setWebViewClient(new WebViewClient() {  
		    @Override  
		    public void onPageFinished(WebView view, String url)  
		    {  
		        wvNoticias.loadUrl("javascript:" +
		        		"function remove(id){return (elem=document.getElementById(id)).parentNode.removeChild(elem);}" +
		        		"remove(users);" +
		        		"remove(YouNews);" +
		        		"remove(ckformcontainer);" +
		        		
		        		
		        		"(function() { " +  
		                "document.getElementsByTag('div')[4].style.height='4000px';  " +  
		                "})()");  
		    }  
		});  
		*/
		
		/*
		myHTML = "<!doctype html>"+

		"<html>"+
		"<head><title >Este es el titulo</title></head>" +
		"<body><h1>Bienvenido a nuestra pagina</h1><p>parrafo 3 para para paragraff</p>" +
		"<a href='http://www.google.html'>voy a tu segunda pagina </a>" +
		"</body>" +
		"</html>";
		 */
		
		
		textHtml = "<!DOCTYPE html><html ><head></head><body> "+textHtml+" </body></html>";
		//textHtml = "<!DOCTYPE html><html ><head></head><body>"+"<h1>HOLA ESTOY AKI</h1>"+"</body></html>";
		//wvNoticias.loadUrl("http://www.12y2.com/");  
		Log.i("menWeb", textHtml);
		
		try {
			wvPodcast.loadData(URLEncoder.encode(textHtml,"utf-8").replaceAll("\\+"," "),
					"text/html", "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			
		/*
		 "<tr  style=\"text-align: left;\">" +
		    "<td class=\"center\">" +
		    "<span>" +
		    "<a href=\"http://www.12y2.com/podcast//12y2-Edicion-10-Ene-2013.mp3\" title=\"Download Audio File\" target=\"_blank\" class=\"jce_file_custom\">" +
		    "<img src=\"http://www.12y2.com/plugins/content/mp3browser/downloadtune.jpg\" alt=\"download\" />" +
		    "</a></span></td>" +
		    "<td ><strong>12y2-Edicion-10-Ene-2013</strong><br/></td>" +
		    "<td>" +
		    "<object width=\"200\" height=\"20\" bgcolor=\"#FFFFFF\" data=\"http://www.12y2.com/plugins/content/mp3browser/dewplayer.swf?son=http://www.12y2.com/podcast//12y2-Edicion-10-Ene-2013.mp3&amp;autoplay=0&amp;autoreplay=0\" type=\"application/x-shockwave-flash\">  <param value=\"http://www.12y2.com/plugins/content/mp3browser/dewplayer.swf?son=http://www.12y2.com/podcast//12y2-Edicion-10-Ene-2013.mp3&amp;autoplay=0&amp;autoreplay=0\" name=\"movie\"/><param value=\"#FFFFFF\" name=\"bgcolor\"/></object><br/>" +
		    "</td>" +
		    "<td>58.5 MB</td>" +
		    "<td>146:09 min<br/></td>" +
		    "</tr>" +
		*/
		
		//wvNoticias.loadData(textHtml, "text/html","UTF-8");
		
		
		
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

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
//		numeroFragment = numeroFragmentAnterior;
//		super.onBackPressed();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.noticias, menu);
		return true;
	}

}
