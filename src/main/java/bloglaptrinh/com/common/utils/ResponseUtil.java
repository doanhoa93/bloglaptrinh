package bloglaptrinh.com.common.utils;

import bloglaptrinh.com.web.support.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResponseUtil {

    private Response createResponse(HttpStatus httpStatus, Object data, Map<String, String> errorMessages) {
        return new Response(httpStatus, data, errorMessages);
    }

    public ResponseEntity<Response> buildResponse(Object data, HttpStatus httpStatus, Map<String, String> errorMessages) {
        return new ResponseEntity(createResponse(httpStatus, data, errorMessages), httpStatus);
    }

    public ResponseEntity<Response> successResponse(Object data, Map<String, String> errorMessages) {
        return buildResponse(data, HttpStatus.OK, errorMessages);
    }

    public ResponseEntity<Response> errorResponse(Object data, Map<String, String> errorMessages) {
        return buildResponse(data, HttpStatus.OK, errorMessages);
    }

    public ResponseEntity<Response> badRequestResponse(Map<String, String> errMap, Map<String, String> errorMessages) {
        return buildResponse(errMap, HttpStatus.BAD_REQUEST, errorMessages);
    }
}
