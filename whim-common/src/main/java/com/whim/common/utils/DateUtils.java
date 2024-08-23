package com.whim.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jince
 * date: 2024/6/28 下午11:37
 * description: 时间工具类
 */
public class DateUtils {
    public static final String FORMAT_01 = "yyyy-MM-dd";
    public static final String FORMAT_02 = "HH:mm:ss";
    public static final String FORMAT_03 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_04 = "yyyyMMddHHmmss";
    public static final String FORMAT_05 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String FORMAT_06 = "yyyyMMdd";
    public static final String FORMAT_07 = "HHmmss";
    public static final String FORMAT_08 = "yyyy/MM/dd";
    public static final String FORMAT_09 = "yyyyMMdd HH:mm:ss";
    public static final String FORMAT_10 = "yyyyMM";
    public static final String FORMAT_11 = "yyyy";

    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间
     */
    public static Date now() {
        return Date.from(Instant.now());
    }

    /**
     * 字符串解析为日期
     *
     * @param date    日期字符串
     * @param pattern 日期格式
     * @return 解析后的日期
     */
    public static Date parse(String date, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            return sdf.parse(date);
        } catch (Exception e) {
            throw new IllegalArgumentException(date + "无法按模式解析: " + pattern, e);
        }
    }

    /**
     * 日期格式化为字符串
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return 格式化后的日期字符串
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            return sdf.format(date);
        }
        return null;
    }

    /**
     * 转换日期字符串格式
     *
     * @param timeStr      原始日期字符串
     * @param sourceFormat 原始格式
     * @param targetFormat 目标格式
     * @return 转换后的日期字符串
     */
    public static String convertFormat(String timeStr, String sourceFormat, String targetFormat) {
        try {
            SimpleDateFormat sourceSdf = new SimpleDateFormat(sourceFormat);
            SimpleDateFormat targetSdf = new SimpleDateFormat(targetFormat);
            Date date = sourceSdf.parse(timeStr);
            return targetSdf.format(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取指定日期前后几天的日期字符串
     *
     * @param dateString 日期字符串
     * @param days       偏移天数
     * @return 偏移后的日期字符串
     * @throws ParseException 解析异常
     */
    public static String getOffsetDate(String dateString, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_04);
        Calendar calendar = Calendar.getInstance();
        if (StringUtils.isNotBlank(dateString)) {
            Date date = sdf.parse(dateString);
            calendar.setTime(date);
        } else {
            calendar.setTimeInMillis(System.currentTimeMillis());
        }
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前时间戳
     *
     * @return 当前时间戳
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取当前日期字符串
     *
     * @param pattern 日期格式
     * @return 格式化后的当前日期字符串
     */
    public static String formatCurrentDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        return sdf.format(currentDate());
    }

    /**
     * 获取当前日期时间字符串
     *
     * @param pattern 日期格式
     * @return 格式化后的当前日期时间字符串
     */
    public static String formatCurrentDateTime(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        return sdf.format(now());
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static Date currentDate() {
        return truncateTime(now());
    }

    /**
     * 将日期时间的时间部分清零
     *
     * @param date 日期时间
     * @return 日期部分
     */
    public static Date truncateTime(Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前年月日字符串
     *
     * @return 当前年月日
     */
    public static String getCurrentDate() {
        return formatCurrentDate(FORMAT_06);
    }

    /**
     * 获取当前年月字符串
     *
     * @return 当前年月
     */
    public static String getCurrentMonth() {
        return formatCurrentDate(FORMAT_10);
    }

    /**
     * 获取当前年份字符串
     *
     * @return 当前年份
     */
    public static String getCurrentYear() {
        return formatCurrentDate(FORMAT_11);
    }

    /**
     * 获取当前时分秒字符串
     *
     * @return 当前时分秒
     */
    public static String getCurrentTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_07);
        return formatter.format(currentTime);
    }

    /**
     * 校验日期字符串是否符合指定格式
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return 是否符合格式
     */
    public static boolean isValidDate(String dateStr, String format) {
        if (StringUtils.isBlank(dateStr)) {
            return false;
        }
        if (dateStr.length() != format.length()) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取前n天的日期字符串
     *
     * @param days 天数
     * @return 前n天的日期字符串
     */
    public static String getDateBefore(int days) {
        return getDateBeforeWithFormat(FORMAT_06, days);
    }

    /**
     * 获取前n天的日期字符串
     *
     * @param format 日期格式
     * @param days   天数
     * @return 前n天的日期字符串
     */
    public static String getDateBeforeWithFormat(String format, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -days);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(calendar.getTime());
    }

    /**
     * 获取前n天的日期字符串
     *
     * @param dateStr 日期字符串
     * @param days    天数
     * @return 前n天的日期字符串
     */
    public static String getDateBefore(String dateStr, int days) {
        Date date = parse(dateStr, FORMAT_06);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -days);
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_06);
        return formatter.format(calendar.getTime());
    }

    /**
     * 计算两个日期之间的天数差
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return 天数差
     */
    public static int daysBetween(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {
            return day2 - day1;
        }
    }

    /**
     * LocalDateTime 转 Date
     *
     * @param localDateTime LocalDateTime对象
     * @return Date对象
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date 转 LocalDateTime
     *
     * @param date Date对象
     * @return LocalDateTime对象
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
