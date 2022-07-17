package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        LocalDate ld = LocalDate.parse(date);
        return ld.plusDays(1).toString();
    }

    @Override
    public int getMonthFromDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("E, dd MMM yyyy", Locale.ENGLISH)).getMonth().getValue();
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldc1 = LocalDateTime.parse(date1, formatter);
        LocalDateTime ldc2 = LocalDateTime.parse(date2, formatter);
        LocalDateTime ldc3 = LocalDateTime.parse(date3, formatter);
        if (ldc1.isAfter(ldc2) && ldc1.isAfter(ldc3)) {
            return ldc1.format(formatter);
        } else if (ldc2.isAfter(ldc1) && ldc2.isAfter(ldc3)) {
            return ldc2.format(formatter);
        } else {
            return ldc3.format(formatter);
        }
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return localDate.plusDays(localDate.lengthOfMonth() - localDate.getDayOfMonth()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String sumTimes(String time1, String time2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime1 = LocalTime.parse(time1, formatter);
        LocalTime localTime2 = LocalTime.parse(time2, formatter);
        LocalTime newTime = localTime1.plusHours(localTime2.getHour()).plusMinutes(localTime2.getMinute()).plusSeconds(localTime2.getSecond());
        return newTime.format(formatter);
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return localDate.plusDays(14).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date localDate1, localDate2;
        try {
            localDate1 = sdf.parse(date1);
            localDate2 = sdf.parse(date2);
            return Math.abs((localDate1.getTime() - localDate2.getTime()) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            return 0;
        }
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        String[] array = new String[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        if (localDate.getDayOfWeek().getValue() == 5) {
            array[0] = localDate.minusWeeks(1).format(formatter);
            array[1] = localDate.plusWeeks(1).format(formatter);
        } else {
            array[0] = localDate.minusDays(localDate.getDayOfWeek().getValue() + 2).format(formatter);
            array[1] = localDate.plusDays(5 - localDate.getDayOfWeek().getValue()).format(formatter);
        }
        return array;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return 12 - localDate.getMonth().getValue();
    }
}
