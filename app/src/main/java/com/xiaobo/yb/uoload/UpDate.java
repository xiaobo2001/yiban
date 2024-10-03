package com.xiaobo.yb.uoload;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.alibaba.fastjson2.JSON;
import com.xiaobo.yb.entity.Upload;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UpDate {
    @SuppressLint("HandlerLeak")
    public static boolean AppUpDate(Context context) throws Exception {
        boolean[] result = new boolean[1];
        try {
            result[0] = false;
            String url = "http://8.130.169.254:6294/ybversion";
            int appVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            OkHttpClient httpClient = new OkHttpClient();
            Request getRequest = new Request.Builder()
                    .url(url)
                    .get()
                    .build();

            Call call = httpClient.newCall(getRequest);
            Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    result[0] = true;
                    String[] cont = msg.obj.toString().split("-");
                    AlertDialog.Builder updateDialog = new AlertDialog.Builder(context);
                    updateDialog.setTitle("更新提示");
                    updateDialog.setMessage(cont[0]);
                    updateDialog.setCancelable(false);
                    if (Integer.parseInt(cont[2]) > 0) {
                        updateDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                    }
                    updateDialog.setPositiveButton("更新", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent updateUrl = new Intent();
                            updateUrl.setAction("android.intent.action.VIEW");
                            Uri uri = Uri.parse(cont[1]);
                            updateUrl.setData(uri);
                            context.startActivity(updateUrl);
                        }
                    });
                    updateDialog.show();
                }
            };
            new Thread(() -> {
                try {
                    Response response = call.execute();
                    List<Upload> uploadList = JSON.parseArray(response.body().string(), Upload.class);
                    for (Upload upload : uploadList) {
                        if (appVersion < upload.getVersion()) {
                            Message message = new Message();
                            message.obj = upload.getMessage() + "-" + upload.getUrl() + "-" + upload.getIs();
                            handler.sendMessage(message);
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            Toast.makeText(context, "出现错误了,请联系开发者,WX:liubo520lngw", Toast.LENGTH_SHORT).show();
        }
        return result[0];
    }
}
