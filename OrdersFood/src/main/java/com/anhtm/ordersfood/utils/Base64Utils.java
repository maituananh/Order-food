package com.anhtm.ordersfood.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    public static String encode(Integer val) {
        return Base64.getEncoder().encodeToString(val.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static Integer decode(String val) {
        String s = new String(Base64.getDecoder().decode(val), StandardCharsets.UTF_8);
        return Integer.valueOf(s);
    }
}
