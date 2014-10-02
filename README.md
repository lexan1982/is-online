
Check if internet avaliable (not only connection) call:
<pre>
  cordova.isonline(success, error, 'isOnline');
</pre>
================

If state change - from native will call functions:
<pre>
  activity.sendJavascript("UART.system.Connection.onOnLine()");
</pre>
or
<pre>
  activity.sendJavascript("UART.system.Connection.onOffLine()");
</pre>
