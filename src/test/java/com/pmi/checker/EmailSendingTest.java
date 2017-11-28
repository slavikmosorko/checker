package com.pmi.checker;

import com.pmi.checker.email.IEmailService;
import com.pmi.checker.pmimodel.JobLocation;
import com.pmi.checker.pmimodel.JobPost;
import com.pmi.checker.pmimodel.JobSchedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSendingTest {

    @Autowired
    IEmailService emailService;

    @Test
    public void sendTestEmail() {
        JobPost jobPost = new JobPost();
        JobLocation jobLocation = new JobLocation();
        JobSchedule jobSchedule = new JobSchedule();
        jobPost.setJobLocation(jobLocation);
        jobPost.setJobSchedule(jobSchedule);
        emailService.sendEmailWithJobOffer(jobPost);
    }

}
