package com.example.javaasmserver.utils;

import java.util.UUID;

public class StringUtil {
    public static String generateAccessToken(){
        return UUID.randomUUID().toString();
    }
}
