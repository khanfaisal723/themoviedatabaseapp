package com.example.themoviedatabaseapp;


import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;


public class httpUrlConnectionHelper {
    public static String getDataString(String s) throws IOException {
        InputStream is = null;
        try {
            Log.d(MainActivity.mainActivityTag, "m1");
            URL url = new URL(s);
            Log.d(MainActivity.mainActivityTag, "m2");
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            Log.d(MainActivity.mainActivityTag, "m3");
            c.setReadTimeout(15000);
            c.setConnectTimeout(15000);
            c.setDoInput(true);
            c.setRequestMethod("GET");
            c.connect();
            Log.d(MainActivity.mainActivityTag, "m4");
            int rc = c.getResponseCode();
            String ss = Integer.toString(rc);
            Log.d(MainActivity.mainActivityTag, ss);


            is = c.getInputStream();
            Log.d(MainActivity.mainActivityTag, "m5");

            return readStream(is);


        } catch (Exception e) {
            Log.d(MainActivity.mainActivityTag, "m");
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }


        return null;
    }

    private static String readStream(InputStream is) throws IOException {

        byte[] b = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream out = null;

        try {
            int lenght;
            out = new BufferedOutputStream(baos);
            while ((lenght = is.read(b)) > 0) {

                out.write(b, 0, lenght);
            }
            out.flush();
            return baos.toString();


        } catch (Exception e) {
            Log.d(MainActivity.mainActivityTag, "urc");
            e.printStackTrace();
            return null;
        } finally {
            if (out != null) {
                out.close();
            }

        }

    }
}
