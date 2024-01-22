package com.example.themoviedatabaseapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import android.widget.Toast;

public class ButtonClickListener implements View.OnClickListener {
private final Context context;
    public ButtonClickListener(Context context) {
       this.context=context;
    }

    @Override
    public void onClick(View v) {
        int b=  v.getId();
        if (b ==R.id.btn1) {
            Log.d(MainActivity.mainActivityTag,"2");
           boolean isNetworOk=NetworkCheckHelper.isNetworkConnected(context);
            Log.d(MainActivity.mainActivityTag,"3");
            if (isNetworOk) {
                Log.d(MainActivity.mainActivityTag,"4");
                Toast.makeText(context,"Network Connected", Toast.LENGTH_LONG).show();
                Intent sn=new Intent(context,MyIntentService.class);
                sn.setData(Uri.parse(MainActivity.url1));
                Log.d(MainActivity.mainActivityTag,"5");
                context.startService(sn);
                Log.d(MainActivity.mainActivityTag,"6");


            } else {
                Toast.makeText(context,"Network not connected",Toast.LENGTH_LONG).show();
            }

        }

        }
    }

