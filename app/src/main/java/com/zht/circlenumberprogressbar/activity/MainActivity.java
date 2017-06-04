package com.zht.circlenumberprogressbar.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.zht.circlenumberprogressbar.R;
import com.zht.circlenumberprogressbar.widget.CircleNumberProgressBar;

public class MainActivity extends AppCompatActivity {

    private CircleNumberProgressBar progressBar;

    private static final int PROGRESS_UPDATE = 1;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            int progress = progressBar.getProgress();
            progress += 1;

            if (progress >= 100) {
                handler.removeMessages(PROGRESS_UPDATE);
            }

            progressBar.setProgress(progress);
            handler.sendEmptyMessageDelayed(PROGRESS_UPDATE, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (CircleNumberProgressBar) findViewById(R.id.cnpb_progress);
        handler.sendEmptyMessage(PROGRESS_UPDATE);
//        progressBar.setProgress(80);
    }
}
