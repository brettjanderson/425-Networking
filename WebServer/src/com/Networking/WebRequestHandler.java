package com.Networking;

/**
 * Created by Brettness on 2/6/15.
 */
public class WebRequestHandler {
    private static WebRequestHandler ourInstance = new WebRequestHandler();

    public static WebRequestHandler getInstance() {
        return ourInstance;
    }

    private WebRequestHandler() {
    }

    public static WebResponse processRequest(WebRequest request){
        return null;
    }
}
