package com.claytonpereira.springproject01.services.execeptions;

import java.io.Serial;

public class ServiceEntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceEntityNotFoundException(Object id) {
        super("Entity Not Found! Id: " + id);
    }
}
