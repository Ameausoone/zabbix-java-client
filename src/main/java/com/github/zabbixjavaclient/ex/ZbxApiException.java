package com.github.zabbixjavaclient.ex;

import com.googlecode.jsonrpc4j.JsonRpcClientException;

public class ZbxApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ZbxApiException() {
    }

    public ZbxApiException(String message) {
        super(message);
    }

    public ZbxApiException(Throwable cause) {
        super(cause);
    }

    public ZbxApiException(String message, Throwable cause) {
        super(cause instanceof JsonRpcClientException ? message + ". Underlying exception code : ["
                + ((JsonRpcClientException) cause).getCode() + "], message : [" + ((JsonRpcClientException) cause).getData().asText() + "]"
                : message //
                , cause);
    }

    public ZbxApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
