package com.karzor.audioannotator;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class PlayerActivity extends TabActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		setTitle("AudioAnnotator");
		
		String strSrcName = getIntent().getExtras().getString("SRC_NAME");
		
		TabHost tabHost = getTabHost();
		//tabHost.setup();
		
		Intent intentPlayer = new Intent().setClass(this, TabPlayerActivity.class);
		intentPlayer.putExtra("SRC_NAME", strSrcName);
		TabSpec tabSpecPlayer = tabHost.newTabSpec("Player");
		tabSpecPlayer.setIndicator("Player");
		tabSpecPlayer.setContent(intentPlayer);
		
		Intent intentReview = new Intent().setClass(this, TabReviewActivity.class);
		TabSpec tabSpecReview = tabHost.newTabSpec("Review");
		tabSpecReview.setIndicator("Review");
		tabSpecReview.setContent(intentReview);
		
		tabHost.addTab(tabSpecPlayer);
		tabHost.addTab(tabSpecReview);
		//tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_player, menu);
		return true;
	}
	

}
