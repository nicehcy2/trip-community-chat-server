package java.com.trip.global.error.exception.handler;


import java.com.trip.global.error.GeneralException;
import java.com.trip.global.error.ResponseCode;

public class JwtHandler extends GeneralException {

    public JwtHandler(ResponseCode errorCode) {
        super(errorCode);
    }
}
