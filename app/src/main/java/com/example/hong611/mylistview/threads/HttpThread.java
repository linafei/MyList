package com.example.hong611.mylistview.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hong611 on 2015/8/14.
 */
public class HttpThread extends Thread {
    public static int SHOW_WEB = 1;
    public static int SHOW_IMAGE = 2;

    int tag;

    String url;
    WebView webView;
    ImageView imageView;
    Handler handler;

    public HttpThread(String url, WebView webView, Handler handler) {
        this.url = url;
        this.webView = webView;
        this.handler = handler;
        tag = SHOW_WEB;
    }

    public HttpThread(String url, ImageView imageView, Handler handler) {
        this.url = url;
        this.imageView = imageView;
        this.handler = handler;
        tag = SHOW_IMAGE;
    }

    @Override
    public void run() {
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);

            if (tag == SHOW_IMAGE) {

                connection.setDoInput(true);
                InputStream inputStream = connection.getInputStream();

                FileOutputStream output = null;
                String fileName = String.valueOf(System.currentTimeMillis());
                File newFile = null;

                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File parent = Environment.getExternalStorageDirectory();
                    newFile = new File(parent, fileName);

                    output = new FileOutputStream(newFile);
                }

                byte[] bytes = new byte[2 * 1024];
                int len;
                if (output != null) {
                    while ((len = inputStream.read(bytes)) != -1) {
                        output.write(bytes, 0, len);
                    }
                }

                final Bitmap bitmap = BitmapFactory.decodeFile(newFile.getAbsolutePath());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });

            } else if (tag == SHOW_WEB) {

                final StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String str;

                while ((str = bufferedReader.readLine()) != null) {
                    stringBuffer.append(str);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadData(stringBuffer.toString(), "text/html;charset=utf-8", null);
                    }
                });
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
