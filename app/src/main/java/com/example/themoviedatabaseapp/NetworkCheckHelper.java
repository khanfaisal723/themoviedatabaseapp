package com.example.themoviedatabaseapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkCheckHelper {
      public static boolean isNetworkConnected(Context context){

          ConnectivityManager connectivityManager=(ConnectivityManager)
                  context.getSystemService(Context.CONNECTIVITY_SERVICE);
          try {
              NetworkInfo networkInfo=
                      connectivityManager.getActiveNetworkInfo();
              return networkInfo!=null && networkInfo.isConnectedOrConnecting();
          } catch (Exception e) {
             e.printStackTrace();
              return false;
          }
      }

}
