package com.raiseapps.doceydos;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Recetas extends TabActivity {

	//TextView textoHttp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recetas_activity);
		
		//textoHttp = (TextView)findViewById(R.id.tvHttp);
//		try {
//			textoHttp.setText(new GetHtmlEj().getInternetData());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		TabHost tabHost = getTabHost();
		 
        // Tab for Photos
        TabSpec infopec = tabHost.newTabSpec("Info");
        // setting Title and Icon for the Tab
        infopec.setIndicator("", getResources().getDrawable(R.drawable.porarticulo));
        Intent photosIntent = new Intent(this, RecetasInfo.class);
        infopec.setContent(photosIntent);
 
        // Tab for Songs
        TabSpec listapec = tabHost.newTabSpec("Lista");
        listapec.setIndicator("", getResources().getDrawable(R.drawable.polista));
        Intent songsIntent = new Intent(this, RecetasLista.class);
        listapec.setContent(songsIntent);
 
 
        // Adding all TabSpec to TabHost
        tabHost.addTab(infopec); // Adding photos tab
        tabHost.addTab(listapec); // Adding songs tab
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recetas_activity, menu);
		return true;
	}

}
