package com.pmi.checker.email;

import com.pmi.checker.pmimodel.JobPost;

public interface IEmailService {
    void sendEmailWithJobOffer(JobPost jobPost);
}
