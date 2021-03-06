package com.example.jiangyue.androidap;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jiangyue.androidap.fragment.MyOnTouchListener;
import com.example.jiangyue.androidap.fragment.OnListListener;
import com.example.jiangyue.androidap.fragment.SuperAwesomeCardFragment;
import com.example.jiangyue.androidap.views.viewpager.PagerSlidingTabStrip;


public class MenuActivity extends FragmentActivity implements OnListListener {

    private final Handler handler = new Handler();

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;

    private Drawable oldBackground = null;
    private int currentColor = 0xFF666666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        tabs.setViewPager(pager);

        changeColor(currentColor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sliding, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_contact:
//                QuickContactFragment dialog = new QuickContactFragment();
//                dialog.show(getSupportFragmentManager(), "QuickContactFragment");
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void changeColor(int newColor) {

        tabs.setIndicatorColor(newColor);

        // change ActionBar color just if an ActionBar is available
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//
//            Drawable colorDrawable = new ColorDrawable(newColor);
//            Drawable bottomDrawable = getResources().getDrawable(R.drawable.actionbar_bottom);
//            LayerDrawable ld = new LayerDrawable(new Drawable[]{colorDrawable, bottomDrawable});
//
//            if (oldBackground == null) {
//
//                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
//                    ld.setCallback(drawableCallback);
//                } else {
//                    getActionBar().setBackgroundDrawable(ld);
//                }
//
//            } else {
//
//                TransitionDrawable td = new TransitionDrawable(new Drawable[]{oldBackground, ld});
//
//                // workaround for broken ActionBarContainer drawable handling on
//                // pre-API 17 builds
//                // https://github.com/android/platform_frameworks_base/commit/a7cc06d82e45918c37429a59b14545c6a57db4e4
//                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
//                    td.setCallback(drawableCallback);
//                } else {
//                    getActionBar().setBackgroundDrawable(td);
//                }
//
//                td.startTransition(200);
//
//            }
//
//            oldBackground = ld;
//
//            // http://stackoverflow.com/questions/11002691/actionbar-setbackgrounddrawable-nulling-background-from-thread-handler
//            getActionBar().setDisplayShowTitleEnabled(false);
//            getActionBar().setDisplayShowTitleEnabled(true);
//
//        }

        currentColor = newColor;

    }

    public void onColorClicked(View v) {

        int color = Color.parseColor(v.getTag().toString());
        changeColor(color);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentColor", currentColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentColor = savedInstanceState.getInt("currentColor");
        changeColor(currentColor);
    }

    private Drawable.Callback drawableCallback = new Drawable.Callback() {
        @Override
        public void invalidateDrawable(Drawable who) {
            getActionBar().setBackgroundDrawable(who);
        }

        @Override
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            handler.postAtTime(what, when);
        }

        @Override
        public void unscheduleDrawable(Drawable who, Runnable what) {
            handler.removeCallbacks(what);
        }
    };

    /**
     * implements PagerSlidingTabStrip.IconTabProvider显示icon
     */
    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"消息", "营养师", "秤盘", "手表", "其他"};

        private Fragment[] fragments = new Fragment[]{SuperAwesomeCardFragment.newInstance(1),
                SuperAwesomeCardFragment.newInstance(2), SuperAwesomeCardFragment.newInstance(3), SuperAwesomeCardFragment.newInstance(4), SuperAwesomeCardFragment.newInstance(5)};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

//        @Override
//        public int getPageIconResId(int position){
//            return R.drawable.ic_action_user;
//        }

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoading(String msg) {

    }

    @Override
    public void onLoading(String msg, int progress) {

    }

    @Override
    public void finishLoading() {

    }

    @Override
    public void switchContent(Fragment fragment) {

    }

    @Override
    public void addContent(Fragment fragment) {

    }

    @Override
    public void onBack() {

    }

    @Override
    public void reloadActivity() {

    }

    @Override
    public void switchContent(int rid) {

    }

    @Override
    public void switchContent(int rid, int type) {

    }

    @Override
    public void setInputKeyPan(boolean allow) {

    }

    @Override
    public void setOnTouchListener(MyOnTouchListener listener) {

    }

    @Override
    public void removeOnTouchListener(MyOnTouchListener listener) {

    }

}