
Check if internet avaliable (not only connection) call:
<pre>
  cordova.isonline(callbackSuccess, callbackError, action);
</pre>
params:
        callbackSuccess // Internet Connected
        callbackError   // No Internet Connection
        action          //'isOnline'
        
================

If state change - from native will call functions:
<pre>
  activity.sendJavascript("UART.system.Connection.onOnLine()");
  //or
  //activity.sendJavascript("UART.system.Connection.onOffLine()");
</pre>

