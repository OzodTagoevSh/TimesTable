package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timerListView;

    public void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<>(100);
        for(int i = 1; i <= 100; i++) {
            timesTableContent.add(i + " * " + timesTableNumber + " = " + i * timesTableNumber);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, timesTableContent);
        timerListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerListView = findViewById(R.id.timerListView);
        SeekBar timerSeekBar = findViewById(R.id.timerSeekBar);

        int max = 20;
        int startingPosition = 10;

        timerSeekBar.setMax(max);
        timerSeekBar.setProgress(startingPosition);
        generateTimesTable(startingPosition);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if(progress < min) {
                    timesTableNumber = min;
                    timerSeekBar.setProgress(timesTableNumber);
                } else {
                    timesTableNumber = progress;
                }
                Log.i("SeekBar value", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}