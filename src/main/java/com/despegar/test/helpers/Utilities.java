package com.despegar.test.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    private Utilities(){
    }

    public static String getCurrentDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String getDateAsFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

}
