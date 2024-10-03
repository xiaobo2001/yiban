package com.xiaobo.yb.utli;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.xiaobo.yb.R;
import com.xiaobo.yb.entity.Entity;

public class Alert {
    private static EditText editText;
    private static Button button;

    public static Dialog getDialog(Context context, Entity entity, TextView textView) {
        View view = CoordinatorLayout.inflate(context, R.layout.alert, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(entity.getTitle());
        builder.setView(view);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_launcher);
        Dialog dialog = builder.show();
        editText = (EditText) view.findViewById(R.id.edit);
        editText.setText(entity.getText().trim());
        editText.setHint(entity.getHint());
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().trim().isEmpty()) {
                    textView.setText(editText.getText().toString());
                    dialog.dismiss();
                } else {
                    Toast.makeText(context, "内容为空", Toast.LENGTH_LONG).show();
                }

            }
        });
        return dialog;
    }
}
