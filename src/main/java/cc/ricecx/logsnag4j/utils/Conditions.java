package cc.ricecx.logsnag4j.utils;

import cc.ricecx.logsnag4j.exceptions.LogSnagException;

/**
 * Utility class used to check conditions.
 * @author RiceCX
 */
public class Conditions {

    /**
     * Determines if the given object is null or empty.
     * @param o The object to check.
     * @param error The error message to throw if the object is null or empty.
     */
    public static void checkNotNullOrEmpty(String o, String error) {
        if (o == null || o.isEmpty()) throw new LogSnagException(error);
    }
}
