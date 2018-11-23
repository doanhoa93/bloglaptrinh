package com.bloglaptrinh.app.common.exception;

import com.bloglaptrinh.app.web.support.ParamError;
import com.querydsl.core.types.Constant;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CoreException extends RuntimeException {

    private HttpStatus apiStatus;
    private List<ParamError> data;

    public CoreException(HttpStatus apiStatus) {
        this.apiStatus = apiStatus;
    }

    /**
     * @param apiStatus
     * @param data
     */
    public CoreException(HttpStatus apiStatus, List<ParamError> data) {
        this(apiStatus);
        this.data = data;
    }

    public CoreException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getApiStatus() {
        return apiStatus;
    }

    public List<ParamError> getData() {
        return data;
    }

}
