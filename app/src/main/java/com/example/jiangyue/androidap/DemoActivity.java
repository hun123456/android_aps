package com.example.jiangyue.androidap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by jiangyue on 16/12/26.
 */
public class DemoActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_chart: {
                //图表
                Intent intent = new Intent(this, ChartStockActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_progress: {
                //进度条
                Intent intent = new Intent(this, ProgressActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}