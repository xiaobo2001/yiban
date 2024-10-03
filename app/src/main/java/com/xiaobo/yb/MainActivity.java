package com.xiaobo.yb;


import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.tencent.mmkv.MMKV;
import com.xiaobo.yb.entity.Entity;
import com.xiaobo.yb.uoload.UpDate;
import com.xiaobo.yb.utli.Alert;

import java.util.List;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;

public class MainActivity extends AppCompatActivity {
    private ImageView starsImg;
    private TextView title;
    private TextView nameID;
    private TextView contextID;
    private TextView contextLX;
    private TextView contextStartTime;
    private TextView contextEndTime;
    private TextView contextTime;
    private TextView contextJIA;
    private TextView contextBRPhone;
    private TextView contextJZPhone;
    private TextView contextSFZQ;
    private TextView contextJJPhone;
    private TextView contextJQYY;
    private ImageView save;
    private ImageView topImageItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        MMKV mmkv = MMKV.defaultMMKV();

        Entity entity = new Entity();
        entity.setTitle("修改器");
        entity.setText("");

        starsImg = (ImageView) findViewById(R.id.stars_img_view);
        title = (TextView) findViewById(R.id.top_text);
        nameID = (TextView) findViewById(R.id.context_name_text);
        contextID = (TextView) findViewById(R.id.context_id);
        contextLX = (TextView) findViewById(R.id.context_lixiao);
        contextStartTime = (TextView) findViewById(R.id.context_start_time);
        contextEndTime = (TextView) findViewById(R.id.context_end_time);
        contextTime = (TextView) findViewById(R.id.context_time);
        contextJIA = (TextView) findViewById(R.id.context_jia);
        contextBRPhone = (TextView) findViewById(R.id.context_br_phone);
        contextJZPhone = (TextView) findViewById(R.id.context_jz_phone);
        contextSFZQ = (TextView) findViewById(R.id.context_sfzq);
        contextJJPhone = (TextView) findViewById(R.id.context_jj_phone);
        contextJQYY = (TextView) findViewById(R.id.context_qqyj);
        save = (ImageView) findViewById(R.id.save);
        topImageItem = (ImageView) findViewById(R.id.top_image_item);

        if (mmkv.decodeBool("topImageItem")) {
            title.setEnabled(false);
            nameID.setEnabled(false);
            contextID.setEnabled(false);
            contextStartTime.setEnabled(false);
            contextEndTime.setEnabled(false);
            contextTime.setEnabled(false);
            contextJIA.setEnabled(false);
            contextBRPhone.setEnabled(false);
            contextJZPhone.setEnabled(false);
            contextSFZQ.setEnabled(false);
            contextJJPhone.setEnabled(false);
            contextJQYY.setEnabled(false);
            contextLX.setEnabled(false);
        } else {
            title.setEnabled(true);
            nameID.setEnabled(true);
            contextID.setEnabled(true);
            contextStartTime.setEnabled(true);
            contextEndTime.setEnabled(true);
            contextTime.setEnabled(true);
            contextJIA.setEnabled(true);
            contextBRPhone.setEnabled(true);
            contextJZPhone.setEnabled(true);
            contextSFZQ.setEnabled(true);
            contextJJPhone.setEnabled(true);
            contextJQYY.setEnabled(true);
            contextLX.setEnabled(true);
        }

        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotateAnimation.setDuration(4000);
        rotateAnimation.setInterpolator(new android.view.animation.LinearInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        starsImg.startAnimation(rotateAnimation);

        if (mmkv.decodeString("title") != null) {
            title.setText(mmkv.decodeString("title"));
        }
        if (mmkv.decodeString("nameID") != null) {
            nameID.setText(mmkv.decodeString("nameID"));
        }
        if (mmkv.decodeString("contextBRPhone") != null) {
            contextBRPhone.setText(mmkv.decodeString("contextBRPhone"));
        }
        if (mmkv.decodeString("contextJZPhone") != null) {
            contextJZPhone.setText(mmkv.decodeString("contextJZPhone"));
        }
        if (mmkv.decodeString("contextJJPhone") != null) {
            contextJJPhone.setText(mmkv.decodeString("contextJJPhone"));
        }
        if (mmkv.decodeString("contextID") != null) {
            contextID.setText(mmkv.decodeString("contextID"));
        }
        if (mmkv.decodeString("contextStartTime") != null) {
            contextStartTime.setText(mmkv.decodeString("contextStartTime"));
        }
        if (mmkv.decodeString("contextEndTime") != null) {
            contextEndTime.setText(mmkv.decodeString("contextEndTime"));
        }
        if (mmkv.decodeString("contextTime") != null) {
            contextTime.setText(mmkv.decodeString("contextTime"));
        }
        if (mmkv.decodeString("contextJQYY") != null) {
            contextJQYY.setText(mmkv.decodeString("contextJQYY"));
        }

        try {
            UpDate.AppUpDate(MainActivity.this);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }

        topImageItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mmkv.encode("topImageItem", !mmkv.decodeBool("topImageItem"));
                if (mmkv.decodeBool("topImageItem")) {
                    title.setEnabled(false);
                    nameID.setEnabled(false);
                    contextID.setEnabled(false);
                    contextStartTime.setEnabled(false);
                    contextEndTime.setEnabled(false);
                    contextTime.setEnabled(false);
                    contextJIA.setEnabled(false);
                    contextBRPhone.setEnabled(false);
                    contextJZPhone.setEnabled(false);
                    contextSFZQ.setEnabled(false);
                    contextJJPhone.setEnabled(false);
                    contextJQYY.setEnabled(false);
                    contextLX.setEnabled(false);
                } else {
                    title.setEnabled(true);
                    nameID.setEnabled(true);
                    contextID.setEnabled(true);
                    contextStartTime.setEnabled(true);
                    contextEndTime.setEnabled(true);
                    contextTime.setEnabled(true);
                    contextJIA.setEnabled(true);
                    contextBRPhone.setEnabled(true);
                    contextJZPhone.setEnabled(true);
                    contextSFZQ.setEnabled(true);
                    contextJJPhone.setEnabled(true);
                    contextJQYY.setEnabled(true);
                    contextLX.setEnabled(true);
                }
                Toast.makeText(MainActivity.this, mmkv.decodeBool("topImageItem") ? "不可编辑" : "可编辑", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        save.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mmkv.encode("title", title.getText().toString());
                mmkv.encode("nameID", nameID.getText().toString());
                mmkv.encode("contextBRPhone", contextBRPhone.getText().toString());
                mmkv.encode("contextJZPhone", contextJZPhone.getText().toString());
                mmkv.encode("contextJJPhone", contextJJPhone.getText().toString());
                mmkv.encode("contextID", contextID.getText().toString());
                mmkv.encode("contextStartTime", contextStartTime.getText().toString());
                mmkv.encode("contextEndTime", contextEndTime.getText().toString());
                mmkv.encode("contextTime", contextTime.getText().toString());
                mmkv.encode("contextJQYY", contextJQYY.getText().toString());
                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        contextJQYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入原因");
                Alert.getDialog(MainActivity.this, entity, contextJQYY);
            }
        });
        contextJJPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入紧急电话号码");
                Alert.getDialog(MainActivity.this, entity, contextJJPhone);
            }
        });
        contextSFZQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入是与否");
                Alert.getDialog(MainActivity.this, entity, contextSFZQ);
            }
        });
        contextJZPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入家长电话号码");
                Alert.getDialog(MainActivity.this, entity, contextJZPhone);
            }
        });
        contextBRPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入本人电话号码");
                Alert.getDialog(MainActivity.this, entity, contextBRPhone);
            }
        });
        contextJIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入原因");
                Alert.getDialog(MainActivity.this, entity, contextJIA);
            }
        });
        contextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setText(String.valueOf(DateUtil.between(DateUtil.parse(contextEndTime.getText()), DateUtil.parse(contextStartTime.getText()), DateUnit.DAY)));
                Alert.getDialog(MainActivity.this, entity, contextTime);
            }
        });
        contextEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入结束日期");
                String time = String.valueOf(DateUtil.parse(DateUtil.now(), "yyyy-MM-dd HH:mm"));
                entity.setText(time.substring(0, time.length() - 3));
                Alert.getDialog(MainActivity.this, entity, contextEndTime);
            }
        });
        contextStartTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                entity.setHint("请输入开始日期");
                String time = String.valueOf(DateUtil.parse(DateUtil.now(), "yyyy-MM-dd HH:mm"));
                entity.setText(time.substring(0, time.length() - 3));
                Alert.getDialog(MainActivity.this, entity, contextStartTime);
            }
        });
        contextLX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入是与否");
                Alert.getDialog(MainActivity.this, entity, contextLX);
            }
        });

        contextID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入审批编号");
                String str = "";
                for (int i = 0; i < 12; i++) {
                    int randomNumber = RandomUtil.randomInt(0, 9);
                    str += randomNumber;
                }
                String time = DateUtil.parse(DateUtil.now(), "yyyy-MM-dd").toString();
                String[] timeArray = time.substring(0, 10).split("-");
                entity.setText(timeArray[0] + timeArray[1] + timeArray[2] + str);
                Alert.getDialog(MainActivity.this, entity, contextID);
            }
        });

        nameID.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                entity.setText("()");
                entity.setHint("请输入姓名(学号)");
                Alert.getDialog(MainActivity.this, entity, nameID);
            }
        });

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入姓名的请假条");
                Alert.getDialog(MainActivity.this, entity, title);
                Log.e("cs", title.getText().toString());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ActivityManager mActivityManager = (ActivityManager) MainActivity.this.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> mList = mActivityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : mList) {
            if (runningAppProcessInfo.pid != android.os.Process.myPid()) {
                android.os.Process.killProcess(runningAppProcessInfo.pid);
            }
        }

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}