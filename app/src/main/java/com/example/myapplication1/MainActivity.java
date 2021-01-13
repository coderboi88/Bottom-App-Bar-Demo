package com.example.myapplication1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GestureDetectorCompat;

import com.google.android.material.bottomappbar.BottomAppBar;
//import com.uigitdev.bottombarandfab.uigitdev.design.MBottomBar;
  import com.example.myapplication1.MBottomBar;
import  android.view.MotionEvent;
import android.view.GestureDetector;
//import android.support.v4.app.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    MBottomBar mBottomBar;
    private boolean isOpenMenu2 = false;
    TextView t1;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar = new MBottomBar(findViewById(R.id.home_bottom_bar));
        setFabClick();
        setBarItemClick();
        t1 = findViewById(R.id.t1);
        this.gestureDetector = new GestureDetector(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void setFabClick() {
        mBottomBar.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOpenMenu2 = !isOpenMenu2;
                changeBarMenu();
            }
        });
    }

    private void setBarItemClick() {
        mBottomBar.getBottomBar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bar_search:
                        Toast.makeText(MainActivity.this, "Bar Search Click", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.bar_favorite:
                        Toast.makeText(MainActivity.this, "Bar Favorite Click", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.bar_notifications:
                        Toast.makeText(MainActivity.this, "Bar Notifications Click", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.bar_shopping:
                        Toast.makeText(MainActivity.this, "Bar Shopping Click", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.bar_more:
                        Toast.makeText(MainActivity.this, "Bar More Click", Toast.LENGTH_LONG).show();
                        break;
                }

                return false;
            }
        });

        mBottomBar.getBottomBar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bar Navigation Click", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changeBarMenu() {
        if (isOpenMenu2) {
            mBottomBar.getBottomBar().setNavigationIcon(null);
            mBottomBar.getBottomBar().setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            mBottomBar.getBottomBar().replaceMenu(R.menu.bottom_bar_menu_2);
            mBottomBar.fabAnimation(isOpenMenu2);
        } else {
            mBottomBar.getBottomBar().setNavigationIcon(R.drawable.ic_menu);
            mBottomBar.getBottomBar().setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            mBottomBar.getBottomBar().replaceMenu(R.menu.bottom_bar_menu);
            mBottomBar.fabAnimation(isOpenMenu2);
        }
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        t1.setText("On Single Tap");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        t1.setText("On Double Tap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        t1.setText("On Double Tap Event");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        t1.setText("On Down");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        t1.setText("On Show Press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        t1.setText("On Single Tap Up");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        t1.setText("On Scroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        t1.setText("On Long Press");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        t1.setText("On Fling");
        return false;
    }
}