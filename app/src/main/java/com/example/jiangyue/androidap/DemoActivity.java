package com.example.jiangyue.androidap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jiangyue.androidap.algorithm.lifegame.LifeGameActivity;
import com.example.jiangyue.androidap.util.DisplayUtil;
import com.example.jiangyue.androidap.views.jpardogo.activity.ui.*;

/**
 * Created by jiangyue on 16/12/26.
 */
public class DemoActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        DisplayUtil.init(this);
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
            case R.id.btn_translate: {
                //动态切换
                Intent intent = new Intent(this, FollowingActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_scroll: {
                //固定选择Label
                Intent intent = new Intent(this, LinearActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_tab: {
                //滑页及循环进度条
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_chat: {
                //聊天控件
                Intent intent = new Intent(this, MenuInScrollViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_pinned: {
                //置顶滚动控件
                Intent intent = new Intent(this, PinnedSectionListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_avatar: {
                //点击头像位置缩放
                Intent intent = new Intent(this, ScrollActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_list_effect: {
                //列表滚动效果
                Intent intent = new Intent(this, AppearanceExamplesActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_photo: {
                //图片移动
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_photo_move: {
                //滚动图片
                Intent intent = new Intent(this, com.example.jiangyue.androidap.views.jpardogo.activity.ui.MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_window_manager: {
                //WindowManager应用
                Intent intent = new Intent(this, WindowManagerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_card_io: {
                //识别银行卡号
                Intent intent = new Intent(this, IOCardActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_card_io2: {
                //识别银行卡号2
                Intent intent = new Intent(this, IOTessCardActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_life_game: {
                //生命算法
                Intent intent = new Intent(this, LifeGameActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
