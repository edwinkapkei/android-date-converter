package com.kapke.timedata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Date formats
 * HH - hour - 24 style :: single H will exclude zero eg 04 becomes 4
 * hh - hour - 12 style :: single h will exclude zero eg 04 becomes 4
 * mm - minute
 * ss - second
 * dd - day of month - 28
 * EEE - day of month short name - Tue
 * EEEE - day of month full name - Tuesday
 * MM - month - 02
 * MMM - month short name - Feb
 * MMMM - month full name - February
 * yyyy - year - 2018
 * z - timezone - GMT +3:00
 */

public class ConvertDate {

    /**
     * NOTE: Use the locale that fits your data
     * This file uses Locale.UK for example purposes
     */

    //Calendar variable assigned the calendar object passed in the constructor
    private Calendar mCalendar;

    /**
     * Constructor accepts a calendar object
     *
     * @param calendar object
     */
    public ConvertDate(Calendar calendar) {
        mCalendar = calendar;
    }

    /**
     * @param string_date value whose format corresponds
     *                    with the SimpleDateFormat pattern
     * @param format pattern of the string date being passed. Example : yyyy-MM-dd(SQL default date format)
     * @throws ParseException in the event the string value is invalid.
     * You basically use a try-catch clause
     * NOTE: if the string date does not include time(i.e string date does not include hh:mm),
     * all time related functions should not be used
     */
    public ConvertDate(String string_date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.UK);

        Date date = sdf.parse(string_date);
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(date);
    }

    //Get year eg: 2018
    public String getYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get month number eg: 11
    public String getMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get month short name eg: Feb
    public String getMonthShortName() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get month full name eg: February
    public String getMonthFullName() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get short day name eg: Tue
    public String getShortDayName() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get full day name eg: Tuesday
    public String getDayName() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get day of month eg: 26
    public String getDayOfMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get 24 hour format eg: 13:21:47
    public String get24HourMinuteSecond() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get 12 hour format eg: 12:21:27
    //a in the pattern signifies AM/PM
    public String get12HourMinuteSecond() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }
    //Get 24 hour format with time zone eg: 13:21:47, GMT +3:00
    public String getTimeWithZone() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss, a", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }


    //Get SQL format eg: 2018-12-28
    public String getSQLFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get UK date format eg: 28-12-2018
    public String getUKFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get US date format eg: 12-28-2018
    public String getUSFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get short month name and year eg: Feb, 2018
    public String getMonthYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM, yyyy", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }

    //Get full month name, day and year eg: February 15, 2018
    public String getDayMonthYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy", Locale.UK);
        return String.valueOf(sdf.format(mCalendar.getTime()));
    }
}
