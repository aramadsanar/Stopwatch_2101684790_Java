package com.armada_nasar.stopwatch_2101684790_java;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//teorema aplikasi ini didapat dari buku Head First Android

public class MainActivity extends AppCompatActivity {

    private int mSeconds = 0;
    private boolean mIsRunning = false;
    private boolean mWasRunning = false;
    private final Handler runner = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView timeText = (TextView) findViewById(R.id.timetext);
        timeText.setText("00:00:00");
        //runTimer();
    }

    public void runTimer() {
        final TextView timeText = (TextView) findViewById(R.id.timetext);

        runner.post(new Runnable() {
            @Override
            public void run() {
                int hours = mSeconds/3600;
                int minute = (mSeconds%3600)/60;
                int second = (mSeconds%3600)%60;

                String timeString = "";
                timeString = String.format("%d:%02d:%02d", hours, minute, second);

                if (mIsRunning) {
                    mSeconds++;
                }

                timeText.setText(timeString);
                runner.postDelayed(this, 1000L);
            }
        });
    }


    public void startStopwatch(View view) {
        if (mIsRunning)
            return;

        mIsRunning = true;
        runTimer();
    }

    public void stopStopwatch(View view) {
        mIsRunning = false;
    }

    public void resetStopwatch(View view) {
        mIsRunning = false;
        mSeconds = 0;
    }
}
