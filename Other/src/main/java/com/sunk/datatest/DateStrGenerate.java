package com.sunk.datatest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 按照指定的格式生成指定范围的日期
 *
 * @author sunk
 * @since 2023/1/6
 **/
public class DateStrGenerate {

    public static void main(String[] args) throws ParseException {
        String datePattern = "yyyy_MM_dd";
        String startDateStr = "2023_01_01";
        String endDateStr = "2023_12_31";

        generateDate(datePattern, startDateStr, endDateStr);
    }


    public static void generateDate(String outputDatePattern, String startDateStr, String endDateStr) throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(outputDatePattern);

        final Date startDate = dateFormat.parse(startDateStr);
        final Date endDate = dateFormat.parse(endDateStr);

        final Calendar startCal = Calendar.getInstance();
        final Calendar endCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endCal.setTime(endDate);
        endCal.add(Calendar.DAY_OF_YEAR, 1);

        while (startCal.before(endCal)) {
            final String str = dateFormat.format(startCal.getTime());
            System.out.println(str);
            startCal.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

}
