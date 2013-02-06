//package com.karzor.audioannotator;
//
//import java.io.PrintStream;
//
//import org.apache.http.conn.scheme.PlainSocketFactory;
//
//import android.app.ActionBar;
//import android.app.ActionBar.Tab;
//import android.app.FragmentTransaction;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.NavUtils;
//import android.text.InputType;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class CopyOfMainActivity extends FragmentActivity implements ActionBar.TabListener {
//
//    /**
//     * The serialization (saved instance state) Bundle key representing the
//     * current tab position.
//     */
//    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
//    
//    private static final int TAB_FILE = 11;
//    private static final int TAB_URL = 22;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Set up the action bar to show tabs.
//        final ActionBar actionBar = getActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//        // For each of the sections in the app, add a tab to the action bar.
//        Tab tabFile = actionBar.newTab().setText(R.string.strSourceFile).setTabListener(this);
//        tabFile.setTag(TAB_FILE);
//        actionBar.addTab(tabFile);
//        Tab tabUrl = actionBar.newTab().setText(R.string.strSourceUrl).setTabListener(this);
//        tabUrl.setTag(TAB_URL);
//        actionBar.addTab(tabUrl);
//        //actionBar.addTab(actionBar.newTab().setText(R.string.title_section3).setTabListener(this));
//        
//        //Log.d("OnCreate", actionBar.getTabAt(1).getText().toString());
//        //System.out.println("***************\n");
//    }
//
//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        // Restore the previously serialized current tab position.
//        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
//            getActionBar().setSelectedNavigationItem(
//                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
//        }
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        // Serialize the current tab position.
//        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
//                getActionBar().getSelectedNavigationIndex());
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }
//    
//    @Override
//    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        // When the given tab is selected, show the tab contents in the
//        // container view.
//        Fragment fragment = new DummySectionFragment();
//        Bundle args = new Bundle();
//        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
//        int tag = (Integer) tab.getTag();
//        System.out.println("In OnTabSelected() -- tag = " + tag);
//        args.putInt(DummySectionFragment.ARG_TAB_TYPE, tag);
//        fragment.setArguments(args);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, fragment)
//                .commit();
//    }
//
//    @Override
//    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//    }
//
//    @Override
//    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//    }
//
//    /**
//     * A dummy fragment representing a section of the app, but that simply
//     * displays dummy text.
//     */
//    public static class DummySectionFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        public static final String ARG_SECTION_NUMBER = "section_number";
//        public static final String ARG_TAB_TYPE = "tab_type";
//
//        public DummySectionFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                Bundle savedInstanceState) {
//            // Create a new TextView and set its text to the fragment's section
//            // number argument value.
//            TextView textView = new TextView(getActivity());
//            textView.setGravity(Gravity.CENTER);
//            //textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
//            int tabType = getArguments().getInt(ARG_TAB_TYPE);
//            textView.setText(Integer.toString(tabType));
//            
//            //Log.d("Fragment", getView().toString());
//            System.out.println("In Fragment - tabtype = " + tabType);
//        	//TextView textUrl = new TextView(getActivity());
//        	EditText textUrl = new EditText(getActivity());
//
//            if (tabType == TAB_FILE) {
//            	//FileHandler();
//            } else if (tabType == TAB_URL) {
//            	//UrlHandler();
//            	textUrl.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
//            	textUrl.setHint("http://");
//            	textUrl.setEnabled(true);
//            }
//            return textUrl;
//        }
//        
//        /**
//         * Handles the choosing of a local audio file and loading into the player
//         * @return boolean TRUE-Success, FALSE-Failure
//         */
//        public boolean FileHandler() {
//        	
//        	return true;
//        }
//        
//        public boolean UrlHandler() {
//        	
//        	//InputType.TYPE_TEXT_VARIATION_URI
//        	return true;
//        }
//    }
//
//}
