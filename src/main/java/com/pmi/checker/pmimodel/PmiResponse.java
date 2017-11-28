package com.pmi.checker.pmimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PmiResponse {
    @JsonProperty
    private List<JobPost> JobPosts;
    @JsonProperty
    private PagingDataValues PagingDataValues;
    @JsonProperty
    private String ExternalUrl;
    @JsonProperty
    private String Country;

    public List<JobPost> getJobPosts() {
        return JobPosts;
    }

    public void setJobPosts(List<JobPost> jobPosts) {
        JobPosts = jobPosts;
    }

    public com.pmi.checker.pmimodel.PagingDataValues getPagingDataValues() {
        return PagingDataValues;
    }

    public void setPagingDataValues(com.pmi.checker.pmimodel.PagingDataValues pagingDataValues) {
        PagingDataValues = pagingDataValues;
    }

    public String getExternalUrl() {
        return ExternalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        ExternalUrl = externalUrl;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
