package com.shayanshaikh.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;


public class MainActivity extends ActionBarActivity {

    private Button start;
    private Button stop;
    private Button reset;
    private Chronometer MyChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideStopButton();
        uI();
    }

    public void uI() {
        MyChronometer = (Chronometer) findViewById(R.id.chronometer);
        start = (Button) findViewById(R.id.btstart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyChronometer.start();
                showStopButton();
            }
        });
        stop = (Button) findViewById(R.id.btstop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyChronometer.stop();
                hideStopButton();
            }
        });
        reset = (Button) findViewById(R.id.btreset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyChronometer.setBase(SystemClock.elapsedRealtime());
            }
        });
    }

    private void showStopButton() {
        start.setVisibility(View.GONE);
        reset.setVisibility(View.GONE);
        stop.setVisibility(View.VISIBLE);
    }

    private void hideStopButton() {
        start.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);
        stop.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
