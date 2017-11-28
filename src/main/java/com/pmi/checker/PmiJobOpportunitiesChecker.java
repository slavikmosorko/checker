package com.pmi.checker;

import com.pmi.checker.http.IHttpURLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PmiJobOpportunitiesChecker {

    @Autowired
    IHttpURLConnection pmiHttpURLConnection;

    @Scheduled(fixedRate = 1000 * 60) //1min
    public void checkOpportunities() throws Exception{
        pmiHttpURLConnection.sendGet(null,null);
    }
}
