package com.example.toastdialogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.toastdialogtest.custom.ToastDialog;

public class MainActivity extends AppCompatActivity {
public ToastDialog mToastDialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToastDialog=new ToastDialog.Builder(MainActivity.this)
                        .setMessage("下载中...")
                        .setPosition(Gravity.BOTTOM)
                        .build();
                mToastDialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        mToastDialog.dismiss();
                    }
                }, 2000);



            }

        });

    }
}