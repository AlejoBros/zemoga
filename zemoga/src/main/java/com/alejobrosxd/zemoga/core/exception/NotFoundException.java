package com.alejobrosxd.zemoga.core.exception;

import com.alejobrosxd.zemoga.commons.enums.ExceptionEnum;

public class NotFoundException extends RuntimeException {

    public NotFoundException(ExceptionEnum exception) {
        super(exception.name());
    }

}
