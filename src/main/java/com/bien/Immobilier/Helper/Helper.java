package com.bien.Immobilier.Helper;

public class Helper {
    
    public static String[] getLoginAndPassword(String subject) {
        return subject.split("==");
    }
}
