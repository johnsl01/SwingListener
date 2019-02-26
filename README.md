# SwingListener

Simple java IP port listener with Swing interface.

Sends incoming request to a Swing TextArea - doesn't implement any response.

This is just a simple test tool - initially developed to explore proxy communications.

This tool can listen on the selected port and see what the browser is sending.

The implemention is threaded - a main thread manages the Swung GUI - and starts the listener when a gui button is pressed.

A listener thread listens to the nominated port and spawns a handler thread for each incoming connection.

The handler threads read the incoming data and send it back to the gui process via an exposed method.

(Please don't assume that any of this implementation is a good way of doing what it is attempting to do - but it does work so it may be a starting point for experimentation).

johnsl - Feb 2019.
