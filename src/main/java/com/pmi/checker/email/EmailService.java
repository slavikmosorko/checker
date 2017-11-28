package com.pmi.checker.email;

import com.pmi.checker.pmimodel.JobPost;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
public class EmailService implements IEmailService {

    private final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendEmailWithJobOffer(JobPost jobPost) {
        Runnable emailSenderThread = () -> {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("slavikmosorko@gmail.com");
            message.setSubject("New job post in PMI");
            message.setFrom("SpringBoot@apimail.com");
            StringJoiner emailText = new StringJoiner("");
            emailText.add("[JOB POST]\n");
            emailText.add(jobPost.getJobTitle());
            emailText.add("\n");
            emailText.add(jobPost.getJobLocation().getCityName());
            emailText.add(", ");
            emailText.add(jobPost.getJobSchedule().getName());
            emailText.add("\n");
            emailText.add("Apply at: ");
            emailText.add(jobPost.getApplyUrl());
            message.setText(emailText.toString());
            System.out.println("[EMAIL SENT] " + jobPost.getJobTitle());
            log.info("[EMAIL SENT] " + jobPost.getJobTitle());
            try {
                emailSender.send(message);
            } catch (Exception e) {
                log.error("[ERROR SENDING EMAIL] " + jobPost.getJobTitle());
                e.printStackTrace();
            }
        };
        new Thread(emailSenderThread).start();
    }
}
