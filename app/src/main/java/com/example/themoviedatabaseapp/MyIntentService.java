package com.example.themoviedatabaseapp;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.gson.Gson;

import java.io.IOException;

public class MyIntentService extends IntentService {

    public static String serviceIntentAction="SERVICE_ACTION";
    public static String intentKey="KEY";
    public MyIntentService() {
        super("ggg");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(MainActivity.mainActivityTag,"7");

        String s= null;
        try {
            Uri uri =intent.getData();
            s = httpUrlConnectionHelper.getDataString(uri.toString());



        } catch (IOException e) {
            Log.d(MainActivity.mainActivityTag,"he");
            e.printStackTrace();
        }


        sendDataToMainActivity(s);
        Log.d(MainActivity.mainActivityTag,"8");
    }

    private void sendDataToMainActivity(String s) {
        Intent intent = new Intent(serviceIntentAction);
        intent.putExtra(intentKey,s);
        Log.d(MainActivity.mainActivityTag,"9");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        Log.d(MainActivity.mainActivityTag,"10");
    }


}
