package com.cmct.ysq.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shen
 * @date 2018/7/11
 */
public class Tools {
    public static String getDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static boolean validateNumber(String value) {
        String rule = "([0-9]+|[0-9]+.[0-9]+)";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
