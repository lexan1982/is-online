
Check if internet avaliable (not only connection) call:
<pre>
  cordova.isonline(callbackSuccess, callbackError, action);
</pre>
params:<br/>
&nbsp;&nbsp;callbackSuccess // Internet Connected<br/>
&nbsp;&nbsp;callbackError   // No Internet Connection<br/>
&nbsp;&nbsp;action          //'isOnline'<br/>
        
================

If state change - from native will call functions:
<pre>
  activity.sendJavascript("UART.system.Connection.onOnLine()");
  //or
  //activity.sendJavascript("UART.system.Connection.onOffLine()");
</pre>

