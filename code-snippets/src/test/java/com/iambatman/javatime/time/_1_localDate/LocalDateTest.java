package com.iambatman.javatime.time._1_localDate;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

import static java.time.format.DateTimeFormatter.*;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LocalDateTest {

    @Test
    public void demo_LocalDateNow() {
        // now
        LocalDate date = LocalDate.now();
        System.out.println("Now: " + date);
    }

    @Test
    public void demo_LocalDateOf() {
        // LocalDate.of
        LocalDate date = LocalDate.of(2018, Month.APRIL, 5);

        // get info
        assertEquals(2018, date.getYear());
        assertEquals(4, date.getMonthValue());      // months go from 1 to 12
        assertEquals(5, date.getDayOfMonth());
        assertEquals(30, date.lengthOfMonth());
        assertEquals(false, date.isLeapYear());
        assertEquals(DayOfWeek.THURSDAY, date.getDayOfWeek());
        assertEquals(4, date.getDayOfWeek().getValue());

    }

    @Test
    public void demo_LocalDateTemporalFields() {
        LocalDate date = LocalDate.of(2018, Month.APRIL, 5);
        // get info using Temporal fields
        assertEquals(2018, date.get(ChronoField.YEAR));
        assertEquals(4, date.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(5, date.get(ChronoField.DAY_OF_MONTH));
        assertEquals(4, date.get(ChronoField.DAY_OF_WEEK));
    }

    @Test
    public void demo_LocalDateDefaultParse() {
        // parse
        LocalDate date = LocalDate.parse("2018-04-29");
        assertEquals(2018, date.getYear());
        assertEquals(4, date.getMonthValue());      // months go from 1 to 12
        assertEquals(29, date.getDayOfMonth());
    }

    @Test
    public void demo_LocalDateParse() {
        assertEquals(LocalDate.of(2018, 4, 22), LocalDate.parse("20180422", BASIC_ISO_DATE));

        assertEquals(LocalDate.of(2018, 4, 22), LocalDate.parse("2018-04-22", ISO_LOCAL_DATE));

        assertEquals(LocalDate.of(2018, 4, 22), LocalDate.parse("2018-04-22+05:30", ISO_OFFSET_DATE));

        assertEquals(LocalDate.of(2018, 4, 22), LocalDate.parse("2018-04-22", ISO_DATE));
        assertEquals(LocalDate.of(2018, 4, 22), LocalDate.parse("2018-04-22+05:30", ISO_DATE));
    }
}