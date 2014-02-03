package com.raiseapps.doceydos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.R.bool;
import android.util.Log;

public class GetHtmlEj {
	
	public String getInternetData2(URI website) throws Exception{
		BufferedReader in = null;
		String data = null; 
		String dataCortada= null;
		boolean estoyEnBloque = false;
		try{
			HttpClient client = new DefaultHttpClient();
			//URI website = new URI("http://www.12y2.com/index.php?option=com_content&view=article&id=224&Itemid=111");
			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			StringBuffer sbc = new StringBuffer("");
			
			
			String l = "";
			String nl = System.getProperty("line.separator");
			
			while ((l = in.readLine()) != null) {
				sb.append(l+nl);
				Log.i("OBJETO", l);
				if(l.toString().contains("<div class=\"newsitem_text\">")){
					estoyEnBloque = true;
					Log.i("pass", "estoy true");
				}
				
				
				if(estoyEnBloque){
					//sbc.append(l+nl);
					Log.i("MAL2", l);
					sbc.append(l);
				}
				
				if(l.toString().contains("<!--end news item -->")){
					estoyEnBloque = false;
					Log.i("pass", "estoy false");
				}
				
				Log.i("OBJETIVO", l+nl);
				Log.i("OBJETO", l);
			}
			in.close();
			data = sb.toString();
			dataCortada = sbc.toString();
			//return new JSONObject(data).getString("PROGRAMA");
			
			
			return dataCortada;
			//return dataCortada+"corrector";
			
		}finally{
			if(in != null){
				try{
					in.close();
					return dataCortada;
					//return dataCortada;
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getInternetData(URI website) throws Exception{

		BufferedReader in = null;
		String data = null; 
		String dataCortada= null;
		boolean estoyEnBloque = false;
		try{
			HttpClient client = new DefaultHttpClient();
			//URI website = new URI("http://www.12y2.com/index.php?option=com_content&view=article&id=224&Itemid=111");
			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			StringBuffer sbc = new StringBuffer("");
			
			
			String l = "";
			String nl = System.getProperty("line.separator");
			
			while ((l = in.readLine()) != null) {
				sb.append(l+nl);
				Log.i("OBJETO", l);
				if(l.toString().contains("<!-- START: mp3 Browser -->")){
					estoyEnBloque = true;
					Log.i("pass", "estoy true");
				}
				
				
				if(estoyEnBloque){
					//sbc.append(l+nl);
					Log.i("MAL2", l);
					if(l.toString().contains("%")){
						Log.i("MAL", l);
						l.replace("%", "px");
							
					}
					sbc.append(l);
				}
				
				if(l.toString().contains("<!-- END: mp3 Browser -->")){
					estoyEnBloque = false;
					Log.i("pass", "estoy false");
				}
				
				Log.i("OBJETIVO", l+nl);
				Log.i("OBJETO", l);
			}
			in.close();
			data = sb.toString();
			dataCortada = sbc.toString();
			//return new JSONObject(data).getString("PROGRAMA");
			
			
			return dataCortada;
			//return dataCortada+"corrector";
			
		}finally{
			if(in != null){
				try{
					in.close();
					return dataCortada;
					//return dataCortada;
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	public int Buscacaracter(String cadena, char caracter){
		int index=0;
		
		for(index=0;index<cadena.length();index++){
			if(cadena.charAt(index)==caracter){
				return index;
			}
		}
		
		return index;
	}
	
	public int PrimerCaracter(String cadena){
		int index=0;
		
		for(index=0;index<cadena.length();index++){
			if(cadena.charAt(index)!=' '){
				return index;
			}
		}
		
		return index;
		
	}
	
	public String getInternetData3(URI website) throws Exception{
		
		String arrLink[] = new String[20];
		BufferedReader in = null;
		String data = null; 
		String dataCortada= null;
		boolean estoyEnBloque = false;
		try{
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			
			
			String l = "";
			String nl = System.getProperty("line.separator");
			
			int inicio=0, fin=0;
			
			int j=0;
			while ((l = in.readLine()) != null) {
				
				if(l.toString().contains("receta-del-dia")){
					if(j>=20)
						break;
					
					//inicio = Buscacaracter(l.toString(), '/');
					//arrLink[j] = l.toString().substring(inicio, l.toString().length());
					sb.append(l+nl);
					//arrLink[j] = l.toString();
					//j++;
					l = in.readLine();
					//inicio = PrimerCaracter(l.toString());
					//fin =Buscacaracter(l.toString(), '<');
					//arrLink[j] = l.toString().substring(inicio, fin);
					//arrLink[j] = l.toString();
					sb.append(l+nl);
				}
				//j++;
			}
			in.close();
			data = sb.toString();
			//dataCortada = sbc.toString();
			//return new JSONObject(data).getString("PROGRAMA");
			
			
			return data;
			//return dataCortada+"corrector";
			
		}finally{
			if(in != null){
				try{
					in.close();
					return data;
					//return dataCortada;
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
}
