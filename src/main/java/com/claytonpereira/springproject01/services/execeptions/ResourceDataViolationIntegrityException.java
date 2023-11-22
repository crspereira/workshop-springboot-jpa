package com.claytonpereira.springproject01.services.execeptions;

public class ResourceDataViolationIntegrityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceDataViolationIntegrityException(String msg) {
        super(msg);
    }
}
