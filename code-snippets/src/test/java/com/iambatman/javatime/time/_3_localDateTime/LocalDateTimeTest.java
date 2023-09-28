package com.iambatman.javatime.time._3_localDateTime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

import static java.time.format.DateTimeFormatter.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDateTimeTest {

    @Test
    public void demo_LocalDateTimeNow() {
        // now
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Now: " + dateTime);
    }

    @Test
    public void demo_LocalTimeOf() {
        // LocalDateTime.of
        LocalDateTime dateTime = LocalDateTime.of(2018, Month.APRIL, 5, 18, 59, 34);
        // get info
        assertEquals(2018, dateTime.getYear());
        assertEquals(4, dateTime.getMonthValue());
        assertEquals(5, dateTime.getDayOfMonth());
        assertEquals(18, dateTime.getHour());
        assertEquals(59, dateTime.getMinute());
        assertEquals(34, dateTime.getSecond());
    }

    @Test
    public void demo_LocalTimeTemporalFields() {
        LocalDateTime dateTime = LocalDateTime.of(2018, Month.APRIL, 5, 18, 59, 34);
        // get info using Temporal fields
        assertEquals(2018, dateTime.get(ChronoField.YEAR));
        assertEquals(4, dateTime.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(5, dateTime.get(ChronoField.DAY_OF_MONTH));
        assertEquals(18, dateTime.get(ChronoField.HOUR_OF_DAY));
        assertEquals(59, dateTime.get(ChronoField.MINUTE_OF_HOUR));
        assertEquals(34, dateTime.get(ChronoField.SECOND_OF_MINUTE));
        // AM, PM
        assertEquals(1, dateTime.get(ChronoField.AMPM_OF_DAY));
        assertEquals(6, dateTime.get(ChronoField.HOUR_OF_AMPM));
    }

    @Test
    public void demo_LocalDateTimeBonus() {
        // composing from LocalDate and LocalTime
        LocalDate date = LocalDate.of(2018, Month.APRIL, 11);
        LocalTime time = LocalTime.of(21, 35, 45);

        LocalDateTime dateTime1 = date.atTime(time);
        System.out.println("Date With Time: " + dateTime1);

        LocalDateTime dateTime2 = time.atDate(date);
        System.out.println("Time With Date: " + dateTime2);

        // extracting LocalDate and LocalTime
        LocalDateTime dateTime = LocalDateTime.parse("2018-04-30T23:59:59.332");
        System.out.println("Extracted Date: " + dateTime.toLocalDate());
        System.out.println("Extracted Time: " + dateTime.toLocalTime());
    }

    @Test
    public void demo_LocalTimeDefaultParse() {
        // parse
        LocalDateTime dateTime = LocalDateTime.parse("2018-04-30T23:59:59.332");

        assertEquals(2018, dateTime.getYear());
        assertEquals(4, dateTime.getMonthValue());
        assertEquals(30, dateTime.getDayOfMonth());
        assertEquals(23, dateTime.getHour());
        assertEquals(59, dateTime.getMinute());
        assertEquals(59, dateTime.getSecond());
    }

    @Test
    public void demo_LocalTimeParse() {
        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                LocalDateTime.parse("2018-04-22T19:58:31", ISO_LOCAL_DATE_TIME)
        );


        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                LocalDateTime.parse("2018-04-22T19:58:31+05:30", ISO_OFFSET_DATE_TIME)
        );


        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                LocalDateTime.parse("2018-04-22T19:58:31", ISO_DATE_TIME)
        );
        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                LocalDateTime.parse("2018-04-22T19:58:31+05:30", ISO_DATE_TIME)
        );
        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                LocalDateTime.parse("2018-04-22T19:58:31+05:30[Asia/Kolkata]", ISO_DATE_TIME)
        );


        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                LocalDateTime.parse("2018-04-22T19:58:31+05:30", ISO_ZONED_DATE_TIME)
        );
        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                LocalDateTime.parse("2018-04-22T19:58:31+05:30[Asia/Kolkata]", ISO_ZONED_DATE_TIME)
        );
    }
}
