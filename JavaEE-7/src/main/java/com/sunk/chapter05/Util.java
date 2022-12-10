package com.sunk.chapter05;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Util {

    public static void main(String[] args) throws ParseException {

    }
}


/*
 * 案例：字符串工具类
 */
class StringUtil {

    // 非空判断
    public static boolean isEmpty(String str) {
        // 字符串为 null，字符串为空，字符串仅包含空格 都认为字符串为空
        if (str == null || "".equals(str.trim())) {
            return true;
        }

        return false;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    // 生产随机字符串
    public static String mkString() {
        return UUID.randomUUID().toString();
    }

    public static String mkString(String from, int length) {
        if (length < 1) {
            return "";
        } else {
            final char[] chars = from.toCharArray();
            final Random random = new Random();

            final StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                builder.append(chars[random.nextInt(chars.length)]);
            }
            return builder.toString();
        }
    }

    // 转换字符串 ISO8859-1 => UTF8
    public static String transform(String from, String encodeFrom, String encodeTo) throws UnsupportedEncodingException {
        return new String(from.getBytes(encodeFrom), encodeTo);
    }

    // 将字符串转换为日期
    public static Date parseDate(String dateStr, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(dateStr);
    }

    // 将日期转换为字符串
    public static String formatDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }
}
