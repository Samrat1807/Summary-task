package com.samrat.summarytask.excep;

public class EmptyFileException extends  RuntimeException{
    public EmptyFileException(String message) {
        super(message);
    }
}
