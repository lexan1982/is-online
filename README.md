
Check if internet avaliable (not only connection) call:
<pre>
  cordova.isonline(callbackSuccess, callbackError, action);
</pre>
params:<br/>
        callbackSuccess // Internet Connected<br/>
        callbackError   // No Internet Connection<br/>
        action          //'isOnline'<br/>
        
================

If state change - from native will call functions:
<pre>
  activity.sendJavascript("UART.system.Connection.onOnLine()");
  //or
  //activity.sendJavascript("UART.system.Connection.onOffLine()");
</pre>

