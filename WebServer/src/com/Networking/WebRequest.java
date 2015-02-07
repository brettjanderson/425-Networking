package com.Networking;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Brettness on 2/6/15.
 */
public class WebRequest {

    private StringTokenizer tokenizer;
    private String method;
    private String uri;
    private String httpVersion;
    private String host;
    private String connection;
    private String accept;
    private String userAgent;
    private String acceptEncoding;
    private String acceptLanguage;

    public WebRequest(String firstLine, Scanner input) {

        tokenizer = new StringTokenizer(firstLine);

        if(tokenizer.hasMoreTokens()){
            method = tokenizer.nextToken();
        } else {
            method = null;
        }

        if(tokenizer.hasMoreTokens()){
            uri = tokenizer.nextToken();
        } else {
            uri = null;
        }

        if(tokenizer.hasMoreTokens()){
            httpVersion = tokenizer.nextToken();
        } else {
            httpVersion = null;
        }

    }
}
