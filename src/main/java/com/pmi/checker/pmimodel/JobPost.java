package com.pmi.checker.pmimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobPost {
    @JsonProperty
    private String JobTitle;
    @JsonProperty
    private String ApplyUrl;
    @JsonProperty
    private JobLocation JobLocation;
    @JsonProperty
    private JobSchedule JobSchedule;

    public String getApplyUrl() {
        return ApplyUrl;
    }

    public void setApplyUrl(String applyUrl) {
        ApplyUrl = applyUrl;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public com.pmi.checker.pmimodel.JobLocation getJobLocation() {
        return JobLocation;
    }

    public void setJobLocation(com.pmi.checker.pmimodel.JobLocation jobLocation) {
        JobLocation = jobLocation;
    }

    public com.pmi.checker.pmimodel.JobSchedule getJobSchedule() {
        return JobSchedule;
    }

    public void setJobSchedule(com.pmi.checker.pmimodel.JobSchedule jobSchedule) {
        JobSchedule = jobSchedule;
    }
}
