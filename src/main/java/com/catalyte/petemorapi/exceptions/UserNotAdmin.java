package com.catalyte.petemorapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Call a manager")
public class UserNotAdmin extends RuntimeException{
}
