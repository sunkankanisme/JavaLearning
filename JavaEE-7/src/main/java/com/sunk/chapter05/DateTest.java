package com.sunk.chapter05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {
        /*
         * 日期类
         */

        // 1 获取当前的时间戳毫秒值
        final long currentTimeMillis = System.currentTimeMillis();

        // 2 日期类 Date
        final Date date = new Date();
        System.out.println(date);       // Sat Dec 10 20:18:32 CST 2022

        // 根据时间戳构建指定的日期对象
        date.setTime(1000);

        // 获取日期的时间戳
        date.getTime();

        // 判断两个日期大小
        final Date date2 = new Date();
        date.before(date2);
        date.after(date2);

        // 日志转换类 SimpleDateFormat
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        // 日期转字符串
        final String dateStr = dateFormat.format(date);
        System.out.println(dateStr);    // 2022-12-10 20:20:00.000
        // 字符串转日期
        String dateStr2 = "2020-12-01 12:00:00.000";
        final Date date1 = dateFormat.parse(dateStr2);

        // 3 Calendar 日历类
        final Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        // 获取年月日
        calendar.get(Calendar.YEAR);
        // 月份是从 0 开始的 0-11
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.DATE);
        calendar.get(Calendar.DAY_OF_MONTH);

        // 设置日期
        calendar.set(2022, 11, 4);

        // 日期的加减
        calendar.add(Calendar.DATE, 1);

        System.out.println("================");
        calendar.getMaximum(Calendar.DAY_OF_MONTH);
        calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(calendar.getMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        "".repeat(10);
    }
}
