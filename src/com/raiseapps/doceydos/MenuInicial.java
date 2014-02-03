package com.raiseapps.doceydos;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

public class MenuInicial extends Activity {
	
	ImageButton ibPodcast;
	ImageButton ibRecetas;
	ImageButton ibEnvivo;
	
	ToggleButton tbPlayStop;
	MediaPlayer lifeStream = new MediaPlayer();
	//ProgressBar pgLoadingMusic;
	ImageView ivSandClock;

	Handler h=new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_inicial_activity);
		
		ibPodcast = (ImageButton)findViewById(R.id.ibPodcast);
		ibRecetas = (ImageButton)findViewById(R.id.ibRecetas);
		ibEnvivo = (ImageButton)findViewById(R.id.ibEnvivo);
		ibPodcast.setOnClickListener(ibMenuOnClickListener);
		ibRecetas.setOnClickListener(ibMenuOnClickListener);
		ibEnvivo.setOnClickListener(ibMenuOnClickListener);
		
		tbPlayStop = (ToggleButton) findViewById(R.id.togglePlayStop);
		//pgLoadingMusic = (ProgressBar) findViewById(R.id.ivSandClock);
		ivSandClock = (ImageView) findViewById(R.id.ivSandClock);
		//pgLoadingMusic.setVisibility(View.INVISIBLE);
		ivSandClock.setVisibility(View.INVISIBLE);
		tbPlayStop.setOnClickListener(ibMusicOnClickListener);
		
		//ibStop.setOnClickListener(ibMusicOnClickListener);
		
		try {
			lifeStream.setDataSource("http://67.228.150.184/mobile.php?port=6585");
		} catch (Exception e) {
			e.printStackTrace();//revisarrrrr ortografia!
		    new AlertDialog.Builder(this).setTitle("Media Error").setMessage("ups! there was a media player error, please check internet conection").setNeutralButton("Close", null).show();  
		} 
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
	
	View.OnClickListener ibMusicOnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if(v == tbPlayStop){
//				h.post(new Runnable() {
//
//			        public void run() {
			        	
//			                }
//			            });
				
				if(tbPlayStop.isChecked()){
					ivSandClock.setVisibility(View.VISIBLE);
					//pgLoadingMusic.
					h.post(new Runnable() {
						
						@Override
						public void run() {
							try {
								lifeStream.prepare();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							lifeStream.start();
							ivSandClock.setVisibility(View.INVISIBLE);
						}
					});
					//if(lifeStream.isPlaying())	
				}else{
					lifeStream.stop();
					
					
				}
			
			}
			/*
			
			if(v == ibPlay){
				ibStop.setVisibility(ImageButton.VISIBLE);
				ibPlay.setVisibility(ImageButton.INVISIBLE);
				try {
					lifeStream.prepare();
				} catch (Exception e) {
					///new AlertDialog.Builder(this).setTitle("Media Error").setMessage("ups! there was a media player error, please check internet conection").setNeutralButton("Close", null).show();  
					e.printStackTrace();
				}
				lifeStream.start();
				
				
				
			}if(v == ibStop){
				ibStop.setVisibility(ImageButton.INVISIBLE);
				ibPlay.setVisibility(ImageButton.VISIBLE);
				lifeStream.stop();
			}
			*/
		}
	};
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
//		numeroFragment = numeroFragmentAnterior;
//		super.onBackPressed();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_inicial_activity, menu);
		return true;
	}

}
