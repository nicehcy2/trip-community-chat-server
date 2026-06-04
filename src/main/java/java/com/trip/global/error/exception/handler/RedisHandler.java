package java.com.trip.global.error.exception.handler;

import java.com.trip.global.error.GeneralException;
import java.com.trip.global.error.ResponseCode;

public class RedisHandler extends GeneralException {

    public RedisHandler(ResponseCode errorCode) {
        super(errorCode);
    }
}
