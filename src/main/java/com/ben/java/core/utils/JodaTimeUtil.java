package com.ben.java.core.utils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 待完善,有bug
 */
public class JodaTimeUtil {
    public static final String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_IOS8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";

    public static final String OPERATOR_PLUS = "+";
    public static final String OPERATOR_MINUS = "-";

    /**
     * String transfer date
     *
     * @param dateTimeStr
     * @return
     */
    public static Date strToDate(String dateTimeStr) {
        if (StringUtils.isBlank(dateTimeStr)) {
            throw new IllegalArgumentException("dateTimeStr can't be null or ''");
        }
        return strToDate(dateTimeStr, FORMAT_DEFAULT);
    }

    /**
     * 将指定的字符串转化成指定格式的时间
     *
     * @param dateTimeStr
     * @param formatStr
     * @return
     */
    public static Date strToDate(String dateTimeStr, String formatStr) {
        if (StringUtils.isBlank(dateTimeStr)) {
            throw new IllegalArgumentException("dateTimeStr can't be null or ''");
        }
        if (StringUtils.isBlank(formatStr)) {
            throw new IllegalArgumentException("formatStr can't be null or ''");
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /**
     * date transfer String
     *
     * @param date
     * @return
     */
    public static String dateToStr(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date can't be null");
        }
        return dateToStr(date, FORMAT_DEFAULT);
    }


    /**
     * 将日期转化成指定格式的日期字符串
     *
     * @param date
     * @param formatStr
     * @return
     */
    public static String dateToStr(Date date, String formatStr) {
        if (date == null) {
            throw new IllegalArgumentException("Date can't be null");
        }
        if (StringUtils.isBlank(formatStr)) {
            throw new IllegalArgumentException("formatStr can't be null or ''");
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    /**
     * 对某个时间进行加减second操作
     *
     * @param date
     * @param operator
     * @param offset
     * @return
     */
    public static Date operateSecond(Date date, String operator, int offset) {
        DateTime dateTime;
        if (date == null) {
            throw new IllegalArgumentException("Date can't be null");
        }

        if (StringUtils.isBlank(operator)) {
            throw new IllegalArgumentException("operator can't be null or ''");
        }

        if (!(operator.equals(JodaTimeUtil.OPERATOR_PLUS) || operator.equals(JodaTimeUtil.OPERATOR_MINUS))) {
            throw new IllegalArgumentException("this operator is not  support");
        }

        if (operator.equals(JodaTimeUtil.OPERATOR_PLUS)) {
            dateTime = new DateTime(date).plusSeconds(offset);
        } else {
            dateTime = new DateTime(date).minusSeconds(offset);
        }

        return strToDate(dateToStr(dateTime.toDate(), JodaTimeUtil.FORMAT_YYYYMMDDHHMMSS), JodaTimeUtil.FORMAT_YYYYMMDDHHMMSS);

    }

    public static void main(String[] args) {
        System.out.println(JodaTimeUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(JodaTimeUtil.strToDate("2010-01-01 11:11:11", "yyyy-MM-dd HH:mm:ss"));
        System.out.println("--------重载方法测试---------");
        System.out.println(JodaTimeUtil.dateToStr(new Date()));
        System.out.println(JodaTimeUtil.strToDate("2019-04-10 08:53:05"));

        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(dateTime.plusDays(90).toString("E MM/dd/yyyy HH:mm:ss.SSS"));

//        //方法四：ISO8601形式生成
////         DateTime dt4 = new DateTime("2012-05-20");
////         System.out.println(dt4);
////         DateTime dt5 = new DateTime("2012-05-20T13:14:00");
////         System.out.println(dt5);
////
////        //只需要年月日的时候
////         LocalDate localDate = new LocalDate(2009, 9, 6);// September 6, 2009
////         System.out.println(localDate);
////
////         //只需要时分秒毫秒的时候
////         LocalTime localTime = new LocalTime(13, 30, 26, 0);// 1:30:26PM
////         System.out.println(localTime);

    }
}