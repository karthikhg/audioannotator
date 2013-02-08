package com.karzor.audioannotator;

import group.pals.android.lib.ui.filechooser.FileChooserActivity;
import group.pals.android.lib.ui.filechooser.io.localfile.LocalFile;
import group.pals.android.lib.ui.filechooser.services.IFileProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

import android.R.raw;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
	private static final int _ReqChooseFile = 0;
	public static final int SOURCE_TYPE_FILE = 1;
	public static final int SOURCE_TYPE_URL = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		
		// Initial state setup
		// 1. Make the URL input box and button invisible till the URL radio button is pressed 
		EditText editTextUrl = (EditText) findViewById(R.id.editTextUrl);
		editTextUrl.setVisibility(View.INVISIBLE);
		
		Button buttonUrlGo = (Button) findViewById(R.id.buttonUrlGo);
		buttonUrlGo.setVisibility(View.INVISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main1, menu);
		return true;
	}
	
	public void onRadioSourceFileClicked(View view) {
		
		// Make the URL specific stuff invisible
		EditText editTextUrl = (EditText) findViewById(R.id.editTextUrl);
		editTextUrl.setVisibility(View.INVISIBLE);
		
		Button buttonUrlGo = (Button) findViewById(R.id.buttonUrlGo);
		buttonUrlGo.setVisibility(View.INVISIBLE);
		
		// Invoke the file-chooser activity
		Intent fileIntent = new Intent(MainActivity.this, FileChooserActivity.class);

		fileIntent.putExtra(FileChooserActivity._Rootpath, (Parcelable) new LocalFile("/"));
		
		// Reset main activity before leaving it
		RadioButton radioFile = (RadioButton) findViewById(R.id.radioSourceFile);
		radioFile.setChecked(false);
		
		// Goto file-chooser and directly to player activity when file is chosen.
		startActivityForResult(fileIntent, _ReqChooseFile);
		
	}

	public void onRadioSourceUrlClicked(View view) {
		
		// We need those invisible items visible now...
		EditText editTextUrl = (EditText) findViewById(R.id.editTextUrl);
		editTextUrl.setVisibility(View.VISIBLE);
		
		Button buttonUrlGo = (Button) findViewById(R.id.buttonUrlGo);
		buttonUrlGo.setVisibility(View.VISIBLE);
		
	}
	
	public void onButtonUrlGoClicked(View view) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
		
		EditText editTextUrl = (EditText) findViewById(R.id.editTextUrl);
		String url = editTextUrl.getText().toString();
		//http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3
		
		Bundle sendThis = new Bundle();
		//sendThis.
		sendThis.putString("SOURCE_NAME", url);
		sendThis.putInt("SOURCE_TYPE", SOURCE_TYPE_URL);
		sendThis.putString("SOURCE_PATH", url);

		Intent playerActivity = new Intent(MainActivity.this, PlayerActivity.class);
		playerActivity.putExtras(sendThis);
		
		// Reset main activity before leaving it
		editTextUrl.setVisibility(View.INVISIBLE);		
		Button buttonUrlGo = (Button) findViewById(R.id.buttonUrlGo);
		buttonUrlGo.setVisibility(View.INVISIBLE);
		RadioButton radioUrl = (RadioButton) findViewById(R.id.radioSourceUrl);
		radioUrl.setChecked(false);
		
		// let the music play!
		startActivity(playerActivity);
		//finish();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    switch (requestCode) {
	    case _ReqChooseFile:
	        if (resultCode == RESULT_OK) {
	            /*
	             * a list of files will always return,
	             * if selection mode is single, the list contains one file
	             */
	            List<LocalFile> files = (List<LocalFile>)
	                data.getSerializableExtra(FileChooserActivity._Results);
	            for (File f : files) {
	            	Bundle sendThis = new Bundle();
	        		sendThis.putString("SOURCE_NAME", f.getName());
	        		sendThis.putInt("SOURCE_TYPE", SOURCE_TYPE_FILE);
	        		sendThis.putString("SOURCE_PATH", f.getAbsolutePath());
	        		
	        		Intent playerActivity = new Intent(MainActivity.this, PlayerActivity.class);
	        		playerActivity.putExtras(sendThis);
	        		
	        		startActivity(playerActivity);
	            }
	        }
	        break;
	    }
	}
}
