package com.iambatman.javatime.time._2_localTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;
import static java.time.format.DateTimeFormatter.ISO_OFFSET_TIME;
import static java.time.format.DateTimeFormatter.ISO_TIME;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LocalTimeTest {

    @Test
    public void demo_LocalTimeNow() {
        // now
        LocalTime time = LocalTime.now();
        System.out.println("Now: " + time);
    }

    @Test
    public void demo_LocalTimeOf() {
        // LocalTime.of
        LocalTime time = LocalTime.of(18, 59, 34);
        // get info
        assertEquals(18, time.getHour());
        assertEquals(59, time.getMinute());
        assertEquals(34, time.getSecond());
    }

    @Test
    public void demo_LocalTimeTemporalFields() {
        LocalTime time = LocalTime.of(23, 59, 59);

        // get info using Temporal fields
        assertEquals(23, time.get(ChronoField.HOUR_OF_DAY));
        assertEquals(59, time.get(ChronoField.MINUTE_OF_HOUR));
        assertEquals(59, time.get(ChronoField.SECOND_OF_MINUTE));
        // AM, PM
        assertEquals(1, time.get(ChronoField.AMPM_OF_DAY));     // 0 (AM), 1 (PM)
        assertEquals(11, time.get(ChronoField.HOUR_OF_AMPM));
        // second of day
        assertEquals(86399, time.get(ChronoField.SECOND_OF_DAY));
        assertEquals(0, LocalTime.of(0, 0, 0).get(ChronoField.SECOND_OF_DAY));
    }

    @Test
    public void demo_LocalTimeDefaultParse() {
        // parse
        LocalTime time = LocalTime.parse("23:59:59.332");

        assertEquals(23, time.getHour());
        assertEquals(59, time.getMinute());
        assertEquals(59, time.getSecond());
        assertEquals(332_000_000, time.getNano());
    }

    @Test
    public void demo_LocalTimeParse() {
        assertEquals(LocalTime.of(19, 58, 31), LocalTime.parse("19:58:31", ISO_LOCAL_TIME));

        assertEquals(LocalTime.of(19, 58, 31), LocalTime.parse("19:58:31+05:30", ISO_OFFSET_TIME));

        assertEquals(LocalTime.of(19, 58, 31), LocalTime.parse("19:58:31", ISO_TIME));
        assertEquals(LocalTime.of(19, 58, 31), LocalTime.parse("19:58:31+05:30", ISO_TIME));
    }
}
