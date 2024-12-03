package com.xiaobo.yb;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


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
    private TextView contextBJ;
    private TextView contextTime;
    private TextView contextJIA;
    private TextView contextBRPhone;
    private TextView contextJZPhone;
    private TextView contextSFZQ;
    private TextView contextJJPhone;
    private TextView contextJQYY;
    private Button save;
    private ImageView topImageItem;
    private ImageView bottomImageItem;
    private TextView topText1;
    private CoordinatorLayout sp1;
    private CoordinatorLayout sp2;
    private CoordinatorLayout sp3;
    private TextView sp1NameID;
    private TextView sp2NameID;
    private TextView sp3NameID;
    private TextView sp1Date;
    private TextView sp2Date;
    private TextView sp3Date;
    private View clone;
    private CoordinatorLayout cs;
    private CoordinatorLayout csContext;
    private TextView cs1ContextNameId;
    private TextView cs2ContextNameId;
    private TextView cs3ContextNameId;
    private TextView cs4ContextNameId;
    private TextView cs5ContextNameId;
    private TextView cs6ContextNameId;
    private TextView cs7ContextNameId;
    private TextView cs8ContextNameId;
    private TextView cs9ContextNameId;
    private TextView cs10ContextNameId;
    private TextView sp1Button;
    private TextView sp2Button;
    private TextView sp3Button;
    private Boolean sp2ButtonBol = true;
    private Boolean sp3ButtonBol = true;
    private Boolean cs1ContextNameIdBool = true;
    private Boolean cs2ContextNameIdBool = true;
    private Boolean cs3ContextNameIdBool = true;
    private Boolean cs4ContextNameIdBool = true;
    private Boolean cs5ContextNameIdBool = true;
    private Boolean cs6ContextNameIdBool = true;
    private Boolean cs7ContextNameIdBool = true;
    private Boolean cs8ContextNameIdBool = true;
    private Boolean cs9ContextNameIdBool = true;
    private Boolean cs10ContextNameIdBool = true;

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
        contextBJ = (TextView) findViewById(R.id.context_bujia_text);
        contextStartTime = (TextView) findViewById(R.id.context_start_time);
        contextEndTime = (TextView) findViewById(R.id.context_end_time);
        contextTime = (TextView) findViewById(R.id.context_time);
        contextJIA = (TextView) findViewById(R.id.context_jia);
        contextBRPhone = (TextView) findViewById(R.id.context_br_phone);
        contextJZPhone = (TextView) findViewById(R.id.context_jz_phone);
        contextSFZQ = (TextView) findViewById(R.id.context_sfzq);
        contextJJPhone = (TextView) findViewById(R.id.context_jj_phone);
        contextJQYY = (TextView) findViewById(R.id.context_qqyj);
        save = (Button) findViewById(R.id.save);
        topImageItem = (ImageView) findViewById(R.id.top_image_item);
        bottomImageItem = (ImageView) findViewById(R.id.web_button);
        topText1 = (TextView) findViewById(R.id.top_text1);
        sp1 = (CoordinatorLayout) findViewById(R.id.sp1);
        sp2 = (CoordinatorLayout) findViewById(R.id.sp2);
        sp3 = (CoordinatorLayout) findViewById(R.id.sp3);
        sp1NameID = (TextView) findViewById(R.id.sp1_name_id);
        sp2NameID = (TextView) findViewById(R.id.sp2_name_id);
        sp3NameID = (TextView) findViewById(R.id.sp3_name_id);
        sp1Date = (TextView) findViewById(R.id.sp1_date);
        sp2Date = (TextView) findViewById(R.id.sp2_date);
        sp3Date = (TextView) findViewById(R.id.sp3_date);
        clone = findViewById(R.id.clone);
        cs = (CoordinatorLayout) findViewById(R.id.cs);
        sp1Button = (TextView) findViewById(R.id.sp1_button);
        sp2Button = (TextView) findViewById(R.id.sp2_button);
        sp3Button = (TextView) findViewById(R.id.sp3_button);
        cs1ContextNameId = (TextView) findViewById(R.id.cs1_context_name_id);
        cs2ContextNameId = (TextView) findViewById(R.id.cs2_context_name_id);
        cs3ContextNameId = (TextView) findViewById(R.id.cs3_context_name_id);
        cs4ContextNameId = (TextView) findViewById(R.id.cs4_context_name_id);
        cs5ContextNameId = (TextView) findViewById(R.id.cs5_context_name_id);
        cs6ContextNameId = (TextView) findViewById(R.id.cs6_context_name_id);
        cs7ContextNameId = (TextView) findViewById(R.id.cs7_context_name_id);
        cs8ContextNameId = (TextView) findViewById(R.id.cs8_context_name_id);
        cs9ContextNameId = (TextView) findViewById(R.id.cs9_context_name_id);
        cs10ContextNameId = (TextView) findViewById(R.id.cs10_context_name_id);


        if (mmkv.decodeBool("topImageItem")) {
            title.setEnabled(false);
            nameID.setEnabled(false);
            contextID.setEnabled(false);
            contextStartTime.setEnabled(false);
            contextEndTime.setEnabled(false);
            contextTime.setEnabled(false);
            contextBJ.setEnabled(false);
            contextJIA.setEnabled(false);
            contextBRPhone.setEnabled(false);
            contextJZPhone.setEnabled(false);
            contextSFZQ.setEnabled(false);
            contextJJPhone.setEnabled(false);
            contextJQYY.setEnabled(false);
            contextLX.setEnabled(false);
            sp1NameID.setEnabled(false);
            sp2NameID.setEnabled(false);
            sp3NameID.setEnabled(false);
            sp1Date.setEnabled(false);
            sp2Date.setEnabled(false);
            sp3Date.setEnabled(false);
            cs1ContextNameId.setEnabled(false);
            cs2ContextNameId.setEnabled(false);
            cs3ContextNameId.setEnabled(false);
            cs4ContextNameId.setEnabled(false);
            cs5ContextNameId.setEnabled(false);
            cs6ContextNameId.setEnabled(false);
            cs7ContextNameId.setEnabled(false);
            cs8ContextNameId.setEnabled(false);
            cs9ContextNameId.setEnabled(false);
            cs10ContextNameId.setEnabled(false);
        } else {
            title.setEnabled(true);
            nameID.setEnabled(true);
            contextID.setEnabled(true);
            contextStartTime.setEnabled(true);
            contextBJ.setEnabled(true);
            contextEndTime.setEnabled(true);
            contextTime.setEnabled(true);
            contextJIA.setEnabled(true);
            contextBRPhone.setEnabled(true);
            contextJZPhone.setEnabled(true);
            contextSFZQ.setEnabled(true);
            contextJJPhone.setEnabled(true);
            contextJQYY.setEnabled(true);
            contextLX.setEnabled(true);
            sp1NameID.setEnabled(true);
            sp2NameID.setEnabled(true);
            sp3NameID.setEnabled(true);
            sp1Date.setEnabled(true);
            sp2Date.setEnabled(true);
            sp3Date.setEnabled(true);
            cs1ContextNameId.setEnabled(true);
            cs2ContextNameId.setEnabled(true);
            cs3ContextNameId.setEnabled(true);
            cs4ContextNameId.setEnabled(true);
            cs5ContextNameId.setEnabled(true);
            cs6ContextNameId.setEnabled(true);
            cs7ContextNameId.setEnabled(true);
            cs8ContextNameId.setEnabled(true);
            cs9ContextNameId.setEnabled(true);
            cs10ContextNameId.setEnabled(true);
        }

        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotateAnimation.setDuration(8000);
        rotateAnimation.setInterpolator(new android.view.animation.LinearInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        starsImg.startAnimation(rotateAnimation);

        if (mmkv.decodeString("title") != null) {
            title.setText(mmkv.decodeString("title"));
            topText1.setText(mmkv.decodeString("title"));
        }
        if (mmkv.decodeString("nameID") != null) {
            nameID.setText(mmkv.decodeString("nameID"));
        }
        if (mmkv.decodeString("contextLX") != null) {
            contextLX.setText(mmkv.decodeString("contextLX"));
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
        if (mmkv.decodeString("contextBJ") != null) {
            contextBJ.setText(mmkv.decodeString("contextBJ"));
        }
        if (mmkv.decodeString("contextJIA") != null) {
            contextJIA.setText(mmkv.decodeString("contextJIA"));
        }
        if (mmkv.decodeString("contextTime") != null) {
            contextTime.setText(mmkv.decodeString("contextTime"));
        }
        if (mmkv.decodeString("contextJQYY") != null) {
            contextJQYY.setText(mmkv.decodeString("contextJQYY"));
        }
        if (mmkv.decodeString("contextSFZQ") != null) {
            contextSFZQ.setText(mmkv.decodeString("contextSFZQ"));
        }
        if (mmkv.decodeString("sp1NameID") != null) {
            sp1NameID.setText(mmkv.decodeString("sp1NameID"));
        }
        if (mmkv.decodeString("sp2NameID") != null) {
            sp2NameID.setText(mmkv.decodeString("sp2NameID"));
        }
        if (mmkv.decodeString("sp3NameID") != null) {
            sp3NameID.setText(mmkv.decodeString("sp3NameID"));
        }
        if (mmkv.decodeString("sp1Date") != null) {
            sp1Date.setText(mmkv.decodeString("sp1Date"));
        }
        if (mmkv.decodeString("sp2Date") != null) {
            sp2Date.setText(mmkv.decodeString("sp2Date"));
        }
        if (mmkv.decodeString("sp3Date") != null) {
            sp3Date.setText(mmkv.decodeString("sp3Date"));
        }
        if (mmkv.decodeString("cs1ContextNameId") != null) {
            cs1ContextNameId.setText(mmkv.decodeString("cs1ContextNameId"));
        }
        if (mmkv.decodeString("cs2ContextNameId") != null) {
            cs2ContextNameId.setText(mmkv.decodeString("cs2ContextNameId"));
        }
        if (mmkv.decodeString("cs3ContextNameId") != null) {
            cs3ContextNameId.setText(mmkv.decodeString("cs3ContextNameId"));
        }
        if (mmkv.decodeString("cs4ContextNameId") != null) {
            cs4ContextNameId.setText(mmkv.decodeString("cs4ContextNameId"));
        }
        if (mmkv.decodeString("cs5ContextNameId") != null) {
            cs5ContextNameId.setText(mmkv.decodeString("cs5ContextNameId"));
        }
        if (mmkv.decodeString("cs6ContextNameId") != null) {
            cs6ContextNameId.setText(mmkv.decodeString("cs6ContextNameId"));
        }
        if (mmkv.decodeString("cs7ContextNameId") != null) {
            cs7ContextNameId.setText(mmkv.decodeString("cs7ContextNameId"));
        }
        if (mmkv.decodeString("cs8ContextNameId") != null) {
            cs8ContextNameId.setText(mmkv.decodeString("cs8ContextNameId"));
        }
        if (mmkv.decodeString("cs9ContextNameId") != null) {
            cs9ContextNameId.setText(mmkv.decodeString("cs9ContextNameId"));
        }
        if (mmkv.decodeString("cs10ContextNameId") != null) {
            cs10ContextNameId.setText(mmkv.decodeString("cs10ContextNameId"));
        }

        if (mmkv.decodeBool("sp2ButtonBol")) {
            sp2.setVisibility(View.GONE);
        } else {
            sp2.setVisibility(View.VISIBLE);
        }

        if (mmkv.decodeBool("sp3ButtonBol")) {
            sp3.setVisibility(View.GONE);
        } else {
            sp3.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs4ContextNameIdBool")) {
            cs4ContextNameId.setVisibility(View.GONE);
        } else {
            cs4ContextNameId.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs5ContextNameIdBool")) {
            cs5ContextNameId.setVisibility(View.GONE);
        } else {
            cs5ContextNameId.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs6ContextNameIdBool")) {
            cs6ContextNameId.setVisibility(View.GONE);
        } else {
            cs6ContextNameId.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs7ContextNameIdBool")) {
            cs7ContextNameId.setVisibility(View.GONE);
        } else {
            cs7ContextNameId.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs8ContextNameIdBool")) {
            cs8ContextNameId.setVisibility(View.GONE);
        } else {
            cs8ContextNameId.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs9ContextNameIdBool")) {
            cs9ContextNameId.setVisibility(View.GONE);
        } else {
            cs9ContextNameId.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs10ContextNameIdBool")) {
            cs10ContextNameId.setVisibility(View.GONE);
        } else {
            cs10ContextNameId.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs3ContextNameIdBool")) {
            cs3ContextNameId.setVisibility(View.GONE);
        } else {
            cs3ContextNameId.setVisibility(View.VISIBLE);
        }
        if (mmkv.decodeBool("cs3ContextNameIdBool")) {
            cs3ContextNameId.setVisibility(View.GONE);
        } else {
            cs3ContextNameId.setVisibility(View.VISIBLE);
        }

        try {
            UpDate.AppUpDate(MainActivity.this);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }

        sp1Button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                sp2.setVisibility(View.VISIBLE);
                sp3.setVisibility(View.VISIBLE);
                sp2ButtonBol = false;
                sp3ButtonBol = false;
                mmkv.encode("sp2ButtonBol", sp2ButtonBol);
                mmkv.encode("sp3ButtonBol", sp3ButtonBol);
                return true;
            }
        });

        sp2Button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                sp2.setVisibility(View.GONE);
                sp2ButtonBol = true;
                mmkv.encode("sp2ButtonBol", sp2ButtonBol);
                return true;
            }
        });
        sp3Button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                sp3.setVisibility(View.GONE);
                sp3ButtonBol = true;
                mmkv.encode("sp3ButtonBol", sp3ButtonBol);
                return true;
            }
        });

        cs1ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");
                Alert.getDialog(MainActivity.this, entity, cs1ContextNameId, null);
            }
        });
        cs1ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs2ContextNameId.setVisibility(View.VISIBLE);
                cs3ContextNameId.setVisibility(View.VISIBLE);
                cs4ContextNameId.setVisibility(View.VISIBLE);
                cs5ContextNameId.setVisibility(View.VISIBLE);
                cs6ContextNameId.setVisibility(View.VISIBLE);
                cs7ContextNameId.setVisibility(View.VISIBLE);
                cs8ContextNameId.setVisibility(View.VISIBLE);
                cs9ContextNameId.setVisibility(View.VISIBLE);
                cs10ContextNameId.setVisibility(View.VISIBLE);
                cs2ContextNameIdBool = false;
                cs3ContextNameIdBool = false;
                cs4ContextNameIdBool = false;
                cs5ContextNameIdBool = false;
                cs6ContextNameIdBool = false;
                cs7ContextNameIdBool = false;
                cs8ContextNameIdBool = false;
                cs9ContextNameIdBool = false;
                cs10ContextNameIdBool = false;
                mmkv.encode("cs2ContextNameIdBool", cs2ContextNameIdBool);
                mmkv.encode("cs3ContextNameIdBool", cs3ContextNameIdBool);
                mmkv.encode("cs4ContextNameIdBool", cs4ContextNameIdBool);
                mmkv.encode("cs5ContextNameIdBool", cs5ContextNameIdBool);
                mmkv.encode("cs6ContextNameIdBool", cs6ContextNameIdBool);
                mmkv.encode("cs7ContextNameIdBool", cs7ContextNameIdBool);
                mmkv.encode("cs8ContextNameIdBool", cs8ContextNameIdBool);
                mmkv.encode("cs9ContextNameIdBool", cs9ContextNameIdBool);
                mmkv.encode("cs10ContextNameIdBool", cs10ContextNameIdBool);

                return true;
            }
        });
        cs2ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs2ContextNameId, null);
            }
        });
        cs2ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs2ContextNameId.setVisibility(View.GONE);
                cs2ContextNameIdBool = true;
                mmkv.encode("cs2ContextNameIdBool", cs2ContextNameIdBool);
                return true;
            }
        });
        cs3ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs3ContextNameId, null);
            }
        });
        cs3ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs3ContextNameId.setVisibility(View.GONE);
                cs3ContextNameIdBool = true;
                mmkv.encode("cs3ContextNameIdBool", cs3ContextNameIdBool);
                return true;
            }
        });
        cs4ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs4ContextNameId, null);
            }
        });
        cs4ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs4ContextNameId.setVisibility(View.GONE);
                cs4ContextNameIdBool = true;
                mmkv.encode("cs4ContextNameIdBool", cs4ContextNameIdBool);
                return true;
            }
        });
        cs5ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs5ContextNameId, null);
            }
        });
        cs5ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs5ContextNameId.setVisibility(View.GONE);
                cs5ContextNameIdBool = true;
                mmkv.encode("cs5ContextNameIdBool", cs5ContextNameIdBool);
                return true;
            }
        });
        cs6ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs6ContextNameId, null);
            }
        });
        cs6ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs6ContextNameId.setVisibility(View.GONE);
                cs6ContextNameIdBool = true;
                mmkv.encode("cs6ContextNameIdBool", cs6ContextNameIdBool);
                return true;
            }
        });
        cs7ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs7ContextNameId, null);
            }
        });
        cs7ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs7ContextNameId.setVisibility(View.GONE);
                cs7ContextNameIdBool = true;
                mmkv.encode("cs7ContextNameIdBool", cs7ContextNameIdBool);
                return true;
            }
        });
        cs8ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs8ContextNameId, null);
            }
        });
        cs8ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs8ContextNameId.setVisibility(View.GONE);
                cs8ContextNameIdBool = true;
                mmkv.encode("cs8ContextNameIdBool", cs8ContextNameIdBool);
                return true;
            }
        });
        cs9ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs9ContextNameId, null);
            }
        });
        cs9ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs9ContextNameId.setVisibility(View.GONE);
                cs9ContextNameIdBool = true;
                mmkv.encode("cs9ContextNameIdBool", cs9ContextNameIdBool);
                return true;
            }
        });
        cs10ContextNameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入抄送人");
                entity.setText("xxx(xxx)");

                Alert.getDialog(MainActivity.this, entity, cs10ContextNameId, null);
            }
        });
        cs10ContextNameId.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cs10ContextNameId.setVisibility(View.GONE);
                cs10ContextNameIdBool = true;
                mmkv.encode("cs10ContextNameIdBool", cs10ContextNameIdBool);
                return true;
            }
        });
        sp1Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入日期");
                entity.setText(String.valueOf(DateUtil.parse(DateUtil.now(), "yyyy-MM-dd HH:mm")));
                Alert.getDialog(MainActivity.this, entity, sp1Date, null);
            }
        });
        sp2Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入日期");
                entity.setText(String.valueOf(DateUtil.parse(DateUtil.now(), "yyyy-MM-dd HH:mm")));
                Alert.getDialog(MainActivity.this, entity, sp2Date, null);
            }
        });
        sp3Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入日期");
                entity.setText(String.valueOf(DateUtil.parse(DateUtil.now(), "yyyy-MM-dd HH:mm")));
                Alert.getDialog(MainActivity.this, entity, sp3Date, null);
            }
        });

        sp1NameID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入审批人");
                Alert.getDialog(MainActivity.this, entity, sp1NameID, null);
            }
        });
        sp2NameID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入审批人");
                Alert.getDialog(MainActivity.this, entity, sp2NameID, null);
            }
        });
        sp3NameID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入审批人");
                Alert.getDialog(MainActivity.this, entity, sp3NameID, null);
            }
        });

//        bottomImageItem.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                startActivity(new Intent(MainActivity.this, WebActivity.class));
//                return true;
//            }
//        });

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
                    sp1NameID.setEnabled(false);
                    sp2NameID.setEnabled(false);
                    sp3NameID.setEnabled(false);
                    sp1Date.setEnabled(false);
                    sp2Date.setEnabled(false);
                    sp3Date.setEnabled(false);
                    cs1ContextNameId.setEnabled(false);
                    cs2ContextNameId.setEnabled(false);
                    cs3ContextNameId.setEnabled(false);
                    cs4ContextNameId.setEnabled(false);
                    cs5ContextNameId.setEnabled(false);
                    cs6ContextNameId.setEnabled(false);
                    cs7ContextNameId.setEnabled(false);
                    cs8ContextNameId.setEnabled(false);
                    cs9ContextNameId.setEnabled(false);
                    cs10ContextNameId.setEnabled(false);
                    contextBJ.setEnabled(false);
                } else {
                    title.setEnabled(true);
                    nameID.setEnabled(true);
                    contextID.setEnabled(true);
                    contextStartTime.setEnabled(true);
                    contextEndTime.setEnabled(true);
                    contextBJ.setEnabled(true);
                    contextTime.setEnabled(true);
                    contextJIA.setEnabled(true);
                    contextBRPhone.setEnabled(true);
                    contextJZPhone.setEnabled(true);
                    contextSFZQ.setEnabled(true);
                    contextJJPhone.setEnabled(true);
                    contextJQYY.setEnabled(true);
                    contextLX.setEnabled(true);
                    sp1NameID.setEnabled(true);
                    sp2NameID.setEnabled(true);
                    sp3NameID.setEnabled(true);
                    sp1Date.setEnabled(true);
                    sp2Date.setEnabled(true);
                    sp3Date.setEnabled(true);
                    cs1ContextNameId.setEnabled(true);
                    cs2ContextNameId.setEnabled(true);
                    cs3ContextNameId.setEnabled(true);
                    cs4ContextNameId.setEnabled(true);
                    cs5ContextNameId.setEnabled(true);
                    cs6ContextNameId.setEnabled(true);
                    cs7ContextNameId.setEnabled(true);
                    cs8ContextNameId.setEnabled(true);
                    cs9ContextNameId.setEnabled(true);
                    cs10ContextNameId.setEnabled(true);
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
                mmkv.encode("contextLX", contextLX.getText().toString());
                mmkv.encode("contextBRPhone", contextBRPhone.getText().toString());
                mmkv.encode("contextJZPhone", contextJZPhone.getText().toString());
                mmkv.encode("contextJJPhone", contextJJPhone.getText().toString());
                mmkv.encode("contextID", contextID.getText().toString());
                mmkv.encode("contextBJ", contextBJ.getText().toString());
                mmkv.encode("contextStartTime", contextStartTime.getText().toString());
                mmkv.encode("contextEndTime", contextEndTime.getText().toString());
                mmkv.encode("contextJIA", contextJIA.getText().toString());
                mmkv.encode("contextSFZQ", contextSFZQ.getText().toString());
                mmkv.encode("contextTime", contextTime.getText().toString());
                mmkv.encode("contextJQYY", contextJQYY.getText().toString());
                mmkv.encode("sp1NameID", sp1NameID.getText().toString());
                mmkv.encode("sp2NameID", sp2NameID.getText().toString());
                mmkv.encode("sp3NameID", sp3NameID.getText().toString());
                mmkv.encode("sp1Date", sp1Date.getText().toString());
                mmkv.encode("sp2Date", sp2Date.getText().toString());
                mmkv.encode("sp3Date", sp3Date.getText().toString());
                mmkv.encode("cs1ContextNameId", cs1ContextNameId.getText().toString());
                mmkv.encode("cs2ContextNameId", cs2ContextNameId.getText().toString());
                mmkv.encode("cs3ContextNameId", cs3ContextNameId.getText().toString());
                mmkv.encode("cs4ContextNameId", cs4ContextNameId.getText().toString());
                mmkv.encode("cs5ContextNameId", cs5ContextNameId.getText().toString());
                mmkv.encode("cs6ContextNameId", cs6ContextNameId.getText().toString());
                mmkv.encode("cs7ContextNameId", cs7ContextNameId.getText().toString());
                mmkv.encode("cs8ContextNameId", cs8ContextNameId.getText().toString());
                mmkv.encode("cs9ContextNameId", cs9ContextNameId.getText().toString());
                mmkv.encode("cs10ContextNameId", cs10ContextNameId.getText().toString());
                mmkv.encode("sp2ButtonBol", sp2ButtonBol);
                mmkv.encode("sp3ButtonBol", sp3ButtonBol);
                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        contextJQYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入原因");
                Alert.getDialog(MainActivity.this, entity, contextJQYY, null);
            }
        });
        contextJJPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入紧急电话号码");
                Alert.getDialog(MainActivity.this, entity, contextJJPhone, null);
            }
        });
        contextSFZQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入是与否");
                Alert.getDialog(MainActivity.this, entity, contextSFZQ, null);
            }
        });
        contextJZPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入家长电话号码");
                Alert.getDialog(MainActivity.this, entity, contextJZPhone, null);
            }
        });
        contextBRPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入本人电话号码");
                Alert.getDialog(MainActivity.this, entity, contextBRPhone, null);
            }
        });
        contextJIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入原因");
                Alert.getDialog(MainActivity.this, entity, contextJIA, null);
            }
        });
        contextBJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入是否");
                Alert.getDialog(MainActivity.this, entity, contextBJ, null);
            }
        });
        contextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setText(String.valueOf(DateUtil.between(DateUtil.parse(contextEndTime.getText()), DateUtil.parse(contextStartTime.getText()), DateUnit.DAY)));
                Alert.getDialog(MainActivity.this, entity, contextTime, null);
            }
        });
        contextEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入结束日期");
                String time = String.valueOf(DateUtil.parse(DateUtil.now(), "yyyy-MM-dd HH:mm"));
                entity.setText(time.substring(0, time.length() - 3));
                Alert.getDialog(MainActivity.this, entity, contextEndTime, null);
            }
        });
        contextStartTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                entity.setHint("请输入开始日期");
                String time = String.valueOf(DateUtil.parse(DateUtil.now(), "yyyy-MM-dd HH:mm"));
                entity.setText(time.substring(0, time.length() - 3));
                Alert.getDialog(MainActivity.this, entity, contextStartTime, null);
            }
        });
        contextLX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入是与否");
                Alert.getDialog(MainActivity.this, entity, contextLX, null);
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
                Alert.getDialog(MainActivity.this, entity, contextID, null);
            }
        });

        nameID.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                entity.setText("()");
                entity.setHint("请输入姓名(学号)");
                Alert.getDialog(MainActivity.this, entity, nameID, null);
            }
        });

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entity.setHint("请输入姓名的请假条");
                Alert.getDialog(MainActivity.this, entity, title, topText1);
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