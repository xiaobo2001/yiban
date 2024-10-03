package com.xiaobo.yb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.tencent.mmkv.MMKV;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        MMKV.initialize(this);
        MMKV mmkv = MMKV.defaultMMKV();

        if (mmkv.decodeString("start") != null) {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        } else {
            Toast.makeText(WelcomeActivity.this, "欢迎", Toast.LENGTH_LONG).show();
        }

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        aList = new ArrayList<View>();
        View view1 = CoordinatorLayout.inflate(WelcomeActivity.this, R.layout.one, null);

        View view2 = CoordinatorLayout.inflate(WelcomeActivity.this, R.layout.two, null);

        aList.add(view1);
        aList.add(view2);
        mAdapter = new MyPagerAdapter(aList);
        viewPager.setAdapter(mAdapter);
        TextView textView = (TextView) view2.findViewById(R.id.start_app);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmkv.encode("start", "1");
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            }
        });
    }
}