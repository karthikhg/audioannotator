package com.karzor.audioannotator;


import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class TabPlayerActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_player);

		Bundle extras = getIntent().getExtras();
		TextView textSrcName = (TextView) findViewById(R.id.textViewAudioSrcName);
		textSrcName.setText(extras.getString("SOURCE_NAME"));
		
		int srcType = extras.getInt("SOURCE_TYPE");
		
		MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		@SuppressWarnings("unused")
		String dataSource = "";
		
		switch(srcType) {
		case MainActivity.SOURCE_TYPE_FILE: // File
			dataSource = extras.getString("SOURCE_PATH");
			break;
		case MainActivity.SOURCE_TYPE_URL: // URL
			dataSource = extras.getString("SOURCE_NAME");
			break;
		default:
			textSrcName.setText("SOURCE ERROR!");
			return;
		}
	
		// Set the data source
		try {
			mediaPlayer.setDataSource(dataSource);
			//mediaPlayer.setDataSource(TabPlayerActivity.this, R.raw.brobob.mp3);
//			AssetFileDescriptor afd = getAssets().openFd("brobob.mp3/mpg");
//			mediaPlayer.setDataSource(afd.getFileDescriptor(), 
//									afd.getStartOffset(), afd.getLength());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Prepare the source
		try {
			mediaPlayer.prepare(); // might take long! (for buffering, etc)
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// Let it play!
		mediaPlayer.start();
		
		
		
	}
}

