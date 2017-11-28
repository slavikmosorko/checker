package com.pmi.checker.pmimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PagingDataValues {
    @JsonProperty
    private String CurrentPage;
    @JsonProperty
    private int TotalCount;
    @JsonProperty
    private String PagingNumber;

    public String getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(String currentPage) {
        CurrentPage = currentPage;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }

    public String getPagingNumber() {
        return PagingNumber;
    }

    public void setPagingNumber(String pagingNumber) {
        PagingNumber = pagingNumber;
    }
}
