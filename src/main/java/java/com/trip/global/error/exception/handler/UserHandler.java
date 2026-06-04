package java.com.trip.global.error.exception.handler;


import java.com.trip.global.error.GeneralException;
import java.com.trip.global.error.ResponseCode;

public class UserHandler extends GeneralException {

    public UserHandler(ResponseCode errorCode) { super(errorCode); }
}
