/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

package com.ideateam.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

/**
* This class exposes methods in Cordova that can be called from JavaScript.
*/
public class IsOnline extends CordovaPlugin {

	 private String TAG = "CordovaPlugin isOnline";
	 private boolean isOnline;
     
     /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback context from which we were invoked.
     */
    @SuppressLint("NewApi") 
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("isOnline")) {

        	Log.d(TAG, "..action == isOnline: " + isOnline);
        	
        	if(isOnline)
        		callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, "Internet Connection"));
        	else 
        		callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "No Internet Connection"));
         	
          
        }  else {
            return false;
        }
        return true;
    }
    
    private BroadcastReceiver mConnReceiver = new BroadcastReceiver() 
    {
        @Override
        public void onReceive(Context context, Intent intent) 
        {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if (noConnectivity == true)
            {
                Log.d(TAG, "No internet connection");
                isOnline = false;
            }
            else
            {
                Log.d(TAG, "Interet connection is UP");
                isOnline = true;
            }
        }
    };
    
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    	// TODO Auto-generated method stub
    	super.initialize(cordova, webView);
    	
    	Log.d(TAG, "..initialize       getActivity()");
    	
    	this.cordova.getActivity().registerReceiver(mConnReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    	   
    }
       
    @Override
    public void onResume(boolean multitasking) {
    	// TODO Auto-generated method stub
    	Log.d(TAG, "..onResume       getActivity()");
    	this.cordova.getActivity().registerReceiver(mConnReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    	
    	super.onResume(multitasking);
    	
    }
    
    @Override
    public void onPause(boolean multitasking) {
    	// TODO Auto-generated method stub

    	Log.d(TAG, "..onPause       getActivity()");
    	
    	this.cordova.getActivity().unregisterReceiver(mConnReceiver);    	
    	
    	super.onPause(multitasking);
    }
    
    
}
