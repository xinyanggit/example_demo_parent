package com.yx;

import cn.hutool.core.util.StrUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author test
 * @date 2021年03月22日
 * @time 9:10 下午
 * @since JDK1.8
 */
public class DateUtils {
    public static final String ISO_DATE_FORMAT = "yyyyMMdd";
    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
    public static final String ISO_TIME_FORMAT = "HHmmssSSSzzz";
    public static final String ISO_EXPANDED_TIME_FORMAT = "HH:mm:ss,SSSzzz";
    public static final String ISO_DATE_TIME_FORMAT = "yyyyMMdd'T'HHmmssSSSzzz";
    public static final String ISO_EXPANDED_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss,SSSzzz";
    public static final String TIME_FORMAT = "HHmmss";
    public static final String EXPANDED_TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "yyyyMMdd HHmmss";
    public static final String EXPANDED_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String EXPANDED_DATE_TIME_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String ENGLISH_DATE = "MMM dd, yyyy";
    public static final String ENGLISH_DATE_TIME = "MMM dd, yyyy H:mm:ss.SSS";
    public static final String US_DATE_TIME_1 = "yyyy.MM.dd G 'at' HH:mm:ss z";
    public static final String US_DATE_TIME_2 = "yyyyy.MMMMM.dd GGG hh:mm aaa";
    public static final String US_DATE_TIME_3 = "EEE, d MMM yyyy HH:mm:ss Z";
    public static final int JAN_1_1_JULIAN_DAY = 1721426;
    public static final int EPOCH_JULIAN_DAY = 2440588;
    public static final int EPOCH_YEAR = 1970;
    public static final int ONE_SECOND = 1000;
    public static final int ONE_MINUTE = 60000;
    public static final int ONE_HOUR = 3600000;
    public static final long ONE_DAY = 86400000L;
    public static final long ONE_WEEK = 604800000L;

    public static Date stringToDate(String isoDateString, TimeZone timeZone) {
        return stringToDate(isoDateString, "yyyy-MM-dd HH:mm:ss", timeZone);
    }

    public static Date stringToDate(String isoDateString, String pattern, TimeZone timeZone) {
        if (!StrUtil.isBlank(isoDateString) && !StrUtil.isBlank(pattern) && timeZone != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            df.setTimeZone(timeZone);

            try {
                return df.parse(isoDateString);
            } catch (ParseException var5) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String format(Date date, String pattern, TimeZone timeZone) {
        if (date != null && !StrUtil.isBlank(pattern) && timeZone != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat.format(date);
        } else {
            return null;
        }
    }

    public static Date add(Date date, int field, int amount, TimeZone timeZone) {
        if (date != null && timeZone != null) {
            Calendar cal = GregorianCalendar.getInstance(timeZone);
            cal.setTime(date);
            cal.add(field, amount);
            return cal.getTime();
        } else {
            return null;
        }
    }

    public static Date addYears(Date date, int amount, TimeZone timeZone) {
        return add(date, 1, amount, timeZone);
    }

    public static Date addMonths(Date date, int amount, TimeZone timeZone) {
        return add(date, 2, amount, timeZone);
    }

    public static Date addWeeks(Date date, int amount, TimeZone timeZone) {
        return add(date, 3, amount, timeZone);
    }

    public static Date addDays(Date date, int amount, TimeZone timeZone) {
        return add(date, 5, amount, timeZone);
    }

    public static Date addHours(Date date, int amount, TimeZone timeZone) {
        return add(date, 11, amount, timeZone);
    }

    public static Date addMinutes(Date date, int amount, TimeZone timeZone) {
        return add(date, 12, amount, timeZone);
    }

    public static Date addSeconds(Date date, int amount, TimeZone timeZone) {
        return add(date, 13, amount, timeZone);
    }

    public static Date addMilliseconds(Date date, int amount, TimeZone timeZone) {
        return add(date, 14, amount, timeZone);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int millisToJulianDay(long millis) {
        return 719162 + (int) (millis / 86400000L);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int dateToJulianDay(Date date) {
        return millisToJulianDay(date.getTime());
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int diffSeconds(Date early, Date late) {
        return (int) (late.getTime() / 1000L - early.getTime() / 1000L);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int diffMinutes(Date early, Date late, TimeZone timeZone) {
        Calendar c1 = Calendar.getInstance(timeZone);
        Calendar c2 = Calendar.getInstance(timeZone);
        c1.setTime(early);
        c2.setTime(late);
        return (int) (late.getTime() / 60000L - early.getTime() / 60000L);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int diffHours(Date early, Date late, TimeZone timeZone) {
        return (int) (late.getTime() / 3600000L - early.getTime() / 3600000L);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int diffDays(Date early, Date late, TimeZone timeZone) {
        Calendar c1 = Calendar.getInstance(timeZone);
        Calendar c2 = Calendar.getInstance(timeZone);
        c1.setTime(early);
        c2.setTime(late);
        return dateToJulianDay(c2.getTime()) - dateToJulianDay(c1.getTime());
    }

    public static int diffMonths(Date early, Date late, TimeZone timeZone) {
        Calendar c1 = Calendar.getInstance(timeZone);
        Calendar c2 = Calendar.getInstance(timeZone);
        c1.setTime(early);
        c2.setTime(late);
        return c2.get(1) * 12 + c2.get(2) - (c1.get(1) * 12 + c1.get(2));
    }

    public static int diffYears(Date early, Date late, TimeZone timeZone) {
        Calendar c1 = Calendar.getInstance(timeZone);
        Calendar c2 = Calendar.getInstance(timeZone);
        c1.setTime(early);
        c2.setTime(late);
        return c2.get(1) - c1.get(1);
    }

    public static java.sql.Date julianDayToSqlDate(long julian) {
        return new java.sql.Date(julianDayToMillis(julian));
    }

    public static Date julianDayToDate(long julian) {
        return new Date(julianDayToMillis(julian));
    }

    public static long julianDayToMillis(long julian) {
        return (julian - 2440588L + 1721426L) * 86400000L;
    }

    public static float toJulian(Calendar c) {
        int Y = c.get(1);
        int M = c.get(2);
        int D = c.get(5);
        int A = Y / 100;
        int B = A / 4;
        int C = 2 - A + B;
        float E = (float) ((int) (365.25F * (float) (Y + 4716)));
        float F = (float) ((int) (30.6001F * (float) (M + 1)));
        float JD = (float) (C + D) + E + F - 1524.5F;
        return JD;
    }

    public static float toJulian(Date date, TimeZone timeZone) {
        Calendar c = Calendar.getInstance(timeZone);
        c.setTime(date);
        return toJulian(c);
    }

    protected static float normalizedJulian(float JD) {
        float f = (float) Math.round(JD + 0.5F) - 0.5F;
        return f;
    }

    public static Date trunc(Date date, TimeZone timeZone) {
        if (date != null && timeZone != null) {
            String str = format(date, "yyyy-MM-dd", timeZone);
            return stringToDate(str, "yyyy-MM-dd", timeZone);
        } else {
            return null;
        }
    }

    public static Date dayEnd(Date date, TimeZone timeZone) {
        if (date != null && timeZone != null) {
            Calendar c1 = Calendar.getInstance(timeZone);
            c1.setTime(date);
            Calendar c2 = (Calendar) c1.clone();
            c1.clear();
            c1.set(1, c2.get(1));
            c1.set(2, c2.get(2));
            c1.set(5, c2.get(5));
            c1.set(11, 23);
            c1.set(12, 59);
            c1.set(13, 59);
            return c1.getTime();
        } else {
            return null;
        }
    }

    public static boolean isSameDay(Date date1, Date date2, TimeZone timeZone) {
        if (date1 != null && date2 != null && timeZone != null) {
            Calendar cal1 = Calendar.getInstance(timeZone);
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance(timeZone);
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new RuntimeException("parameter illegal");
        }
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new RuntimeException("parameter illegal");
        }
    }

    public static boolean isSameLocalTime(Date date1, Date date2, TimeZone timeZone) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance(timeZone);
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance(timeZone);
            cal2.setTime(date2);
            return isSameLocalTime(cal1, cal2);
        } else {
            throw new RuntimeException("parameter illegal");
        }
    }

    public static boolean isSameLocalTime(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(14) == cal2.get(14) && cal1.get(13) == cal2.get(13) && cal1.get(12) == cal2.get(12) && cal1.get(10) == cal2.get(10) && cal1.get(6) == cal2.get(6) && cal1.get(1) == cal2.get(1) && cal1.get(0) == cal2.get(0) && cal1.getClass() == cal2.getClass();
        } else {
            throw new RuntimeException("parameter illegal");
        }
    }

    public static Date parseMillis(Long millis, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public static int getDayOfWeek(Date date, TimeZone timeZone) {
        Calendar cal = Calendar.getInstance(timeZone);
        cal.setFirstDayOfWeek(2);
        cal.setTime(date);
        int result = cal.get(7);
        return result;
    }

    public static TimeZone getTimeZoneUTC() {
        return TimeZone.getTimeZone("UTC");
    }

    public static TimeZone getTimeZoneNY() {
        return TimeZone.getTimeZone("America/New_York");
    }

    public static TimeZone getTimeZoneCST() {
        return TimeZone.getTimeZone("America/Chicago");
    }
}
