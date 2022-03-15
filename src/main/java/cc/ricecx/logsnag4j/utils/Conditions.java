package cc.ricecx.logsnag4j.utils;

import cc.ricecx.logsnag4j.exceptions.LogSnagException;

public class Conditions {

    public static void checkNotNullOrEmpty(String o, String error) {
        if (o == null || o.isEmpty()) throw new LogSnagException(error);
    }
}
