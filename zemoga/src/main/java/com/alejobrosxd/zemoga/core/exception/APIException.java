package com.alejobrosxd.zemoga.core.exception;

import com.alejobrosxd.zemoga.commons.enums.ExceptionEnum;

public class APIException extends RuntimeException {

    public APIException(ExceptionEnum exception) {
        super(exception.name());
    }

}
