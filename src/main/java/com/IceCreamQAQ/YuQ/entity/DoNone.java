package com.IceCreamQAQ.YuQ.entity;

public class DoNone extends Exception {

    private String message;

    public DoNone(){

    }
    public DoNone(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}