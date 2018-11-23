package com.bloglaptrinh.app.common.exception;

import com.bloglaptrinh.app.common.utils.ResponseUtil;
import com.bloglaptrinh.app.web.support.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ResponseUtil responseUtil;

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = CoreException.class)
    public ResponseEntity<Response> handleApplicationException(CoreException ex, WebRequest request) {
        LOGGER.debug("handleApplicationException", ex);

        ResponseEntity<Response> response;
        if (ex.getApiStatus() == HttpStatus.BAD_REQUEST) {
            response = responseUtil.badRequestResponse(ex.getData());
        } else {
            response = responseUtil.buildResponse(ex.getApiStatus(), ex.getData(), HttpStatus.OK);
        }

        return response;
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity(new Response<>(HttpStatus.BAD_REQUEST, null), headers, status);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Response> handleUncatchException(Exception ex, WebRequest request) {
        LOGGER.error("handleUncatchException", ex);
        return responseUtil.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Please contact System Admin to resolve problem", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
