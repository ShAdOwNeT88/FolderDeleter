package com.iovine.antonio.activestore.dateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public DateUtil(){}

    //Get the local system date
    public String getSystemDate(){
        DateFormat df = new SimpleDateFormat("MM.dd.yyyy");
        Date date = new Date();
        return df.format(date);
    }

    //Get difference between two dates in days
    public long getDateDifference(String start, String end) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy");
        LocalDate date = LocalDate.parse(start, formatter);
        LocalDate date1 = LocalDate.parse(end, formatter);

        long days_difference = date1.toEpochDay() - date.toEpochDay();

        return days_difference;

    }
}
