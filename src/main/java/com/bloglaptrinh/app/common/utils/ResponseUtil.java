package com.bloglaptrinh.app.common.utils;

import com.bloglaptrinh.app.web.support.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResponseUtil {

    private Response createResponse(HttpStatus apiStatus, Object data, Map<String, String> errorMessages) {
        return new Response(apiStatus, data, null);
    }

    public ResponseEntity<Response> buildResponse(HttpStatus apiStatus, Object data, HttpStatus httpStatus, Map<String, String> errorMessages) {
        return new ResponseEntity(createResponse(apiStatus, data), httpStatus);
    }

    public ResponseEntity<Response> successResponse(Object data, Map<String, String> errorMessages) {
        return buildResponse(HttpStatus.OK, data, HttpStatus.OK, );
    }

    public ResponseEntity<Response> badRequestResponse(Map<String, String> errMap) {
        return buildResponse(HttpStatus.BAD_REQUEST, errMap, HttpStatus.BAD_REQUEST);
    }
}
