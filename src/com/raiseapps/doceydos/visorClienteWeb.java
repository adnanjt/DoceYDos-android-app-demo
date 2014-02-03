package com.raiseapps.doceydos;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class visorClienteWeb extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		//return super.shouldOverrideUrlLoading(view, url);
		view.loadUrl(url);
		return true;
	}
	
	/*
	 @Override
	 public void onPageFinished(WebView view, String url){
	     view.loadUrl("javascript:(function() { " +
	             "document.getElementById('YouNews').style.display='none'; " +
	             "})()");
	 }
	 */
	 
	

}
