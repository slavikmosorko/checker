package com.pmi.checker.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmi.checker.email.IEmailService;
import com.pmi.checker.http.soundalert.ISoundAlert;
import com.pmi.checker.pmimodel.JobPost;
import com.pmi.checker.pmimodel.PmiResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class ResponsePrinter implements IResponsePrinter {

    private final Logger log = Logger.getLogger(this.getClass());
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static int responsesCounter = 0;
    private static PmiResponse pmiResponse = null;
    private static List<JobPost> newJobsList = Collections.EMPTY_LIST;
    private static List<JobPost> oldJobsList = Collections.EMPTY_LIST;

    @Autowired
    ISoundAlert soundAlert;
    @Autowired
    IEmailService emailService;

    @Override
    public void printResponse(PmiResponse response) {
        log.info("Response ID: " + responsesCounter);
//        System.out.println("[INFO]Response ID: " + responsesCounter);
        System.out.println("[JOB OPPORTUNITIES LIST]");
        System.out.println("------------------------");
        newJobsList = response.getJobPosts();
        newJobsList.stream().forEach(
                jobPost ->
                        System.out.println("[JOB POST] " + jobPost.getJobTitle() +
                                "\n           " + jobPost.getJobSchedule().getName() +
                                ", " + jobPost.getJobLocation().getCityName())

        );
        System.out.println("------------------------");
        System.out.println("[INFO] JOB OPPORTUNITIES COUNT: " + response.getPagingDataValues().getTotalCount());
        if (newJobsList.size() != oldJobsList.size()) {
            if (responsesCounter != 0) {
                newJobsList.stream()
                        .filter(jobPost -> !oldJobsList.contains(jobPost))
                        .forEach(jobPost -> emailService.sendEmailWithJobOffer(jobPost));
                //soundAlert.playSound(); sound!
            }
            oldJobsList = newJobsList;
        }
        responsesCounter++;
    }

    @Override
    public void parseResponse(StringBuffer response) {
        try {
            pmiResponse = MAPPER.readValue(response.toString(), PmiResponse.class);
            printResponse(pmiResponse);
        } catch (IOException e) {
            log.error("Can't parse PMI Response!");
            e.printStackTrace();
        }
    }
}
