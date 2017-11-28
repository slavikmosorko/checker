package com.pmi.checker.http;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;

@Component
public class PmiHttpURLConnection implements IHttpURLConnection {

    private final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    IResponsePrinter responsePrinter;

    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    public void sendGet(String url, HashMap<String, String> parameters) throws Exception {

        url = "https://www.pmi.com/api/JobFilterWidgetApi/SearchContent?title=&contract=&location=Poland&department=Information+Services&page=0&itemsPerPage=20";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        //log.info("Sending 'GET' request to URL: " + url);
        log.info("Response Code: " + responseCode);
//        System.out.println("\n[INFO]Sending 'GET' request to URL: " + url);
//        System.out.println("[INFO]Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        responsePrinter.parseResponse(response);
    }

    // HTTP POST request
    public void sendPost(String url, HashMap<String, String> parameters) throws Exception {

        url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}
