package com.thoughtfocus.project.exception;

public class UserAlreadyExistsException extends RuntimeException {
public UserAlreadyExistsException(String msg) {
super(msg);
}
}
