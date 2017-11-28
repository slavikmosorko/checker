package com.pmi.checker.http;

import com.pmi.checker.pmimodel.PmiResponse;

public interface IResponsePrinter {
    void printResponse(PmiResponse response);
    void parseResponse(StringBuffer response);
}
