package com.karzor.audioannotator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TabPlayerActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_player);

		TextView textSrcName = (TextView) findViewById(R.id.textViewAudioSrcName);
		textSrcName.setText(getIntent().getExtras().getString("SRC_NAME"));
		
//        TextView textview = new TextView(this);
//        textview.setText("This is Player tab");
//        setContentView(textview);
    }
}
