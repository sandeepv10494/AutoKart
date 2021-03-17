package com.sv.autokart.exceptions;

public class SpringAutoKartException extends RuntimeException{
    public SpringAutoKartException(String exceptionMessage, Exception exception){
        super(exceptionMessage,exception);
    }

    public SpringAutoKartException(String exceptionMessage){
        super(exceptionMessage);
    }
}
