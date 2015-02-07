package com.Networking;

import java.io.PrintStream;

/**
 * Created by Brett Anderson on 2/6/15.
 */
public class WebResponse {

    private String httpVersion;
    private int statusCode;
    private PrintStream outStream;

    public WebResponse(){
    }

    public void sendResponse(PrintStream outStream){
        this.outStream = outStream;

    }

}
