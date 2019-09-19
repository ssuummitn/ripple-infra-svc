package com.ripple.infrasvc.exception;

/**
 * Created by sumit.nagariya on 19/09/19.
 */
public class ExceptionResponse {

    private String errorMessage;
    private String requestedURI;


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestedURI() {
        return requestedURI;
    }

    public void callerURL(final String requestedURI) {
        this.requestedURI = requestedURI;
    }
}
