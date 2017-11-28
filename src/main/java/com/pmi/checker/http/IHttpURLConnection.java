package com.pmi.checker.http;

import java.util.HashMap;

public interface IHttpURLConnection {
    void sendGet(String url, HashMap<String, String> parameters) throws Exception ;
    void sendPost(String url, HashMap<String, String> parameters) throws Exception ;
}
