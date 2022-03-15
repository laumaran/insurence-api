package br.com.hdi.insurance.utils;

public class ActiveUtils {

    public static Boolean checkActive(String active) {
        return active != null && active.length() == 4;
    }

}
