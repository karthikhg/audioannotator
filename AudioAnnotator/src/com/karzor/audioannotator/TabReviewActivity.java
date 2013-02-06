package com.karzor.audioannotator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TabReviewActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        TextView textview = new TextView(this);
        textview.setText("This is Review tab");
        setContentView(textview);
    }
}
