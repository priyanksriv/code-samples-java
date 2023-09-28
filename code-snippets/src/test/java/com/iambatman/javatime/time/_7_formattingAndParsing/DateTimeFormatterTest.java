package com.iambatman.javatime.time._7_formattingAndParsing;

import org.junit.jupiter.api.Test;

import java.time.*;

import static java.time.format.DateTimeFormatter.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DateTimeFormatterTest {

    @Test
    public void demo_BasicISODate() {
        assertEquals("20180422", BASIC_ISO_DATE.format(LocalDate.of(2018, 4, 22)));
    }

    @Test
    public void demo_ISOLocal() {
        assertEquals("2018-04-22", ISO_LOCAL_DATE.format(LocalDate.of(2018, 4, 22)));
        assertEquals("19:58:31", ISO_LOCAL_TIME.format(LocalTime.of(19, 58, 31)));

        assertEquals(
                "2018-04-22T19:58:31",
                ISO_LOCAL_DATE_TIME.format(LocalDateTime.of(2018, 4, 22, 19, 58, 31))
        );
    }

    @Test
    public void demo_ISOOffset() {
        assertEquals("2018-04-22+05:30", ISO_OFFSET_DATE.format(LocalDate.of(2018, 4, 22)));
        assertEquals("19:58:31+05:30", ISO_OFFSET_TIME.format(LocalTime.of(19, 58, 31)));

        assertEquals(
                "2018-04-22T19:58:31+05:30",
                ISO_OFFSET_DATE_TIME.format(LocalDateTime.of(2018, 4, 22, 19, 58, 31))
        );
    }

    @Test
    public void demo_ISOInstant() {
        assertEquals(
                "2018-04-22T19:58:31Z",
                ISO_INSTANT.format(Instant.from(LocalDateTime.of(2018, 4, 22, 19, 58, 31).atZone(ZoneId.of("Z"))))
        );
    }

//    @Test
//    public void demo_ISOWithOptionalZones() {
//        assertEquals("2018-04-22", ISO_DATE.format(LocalDate.of(2018, 4, 22)));
//        assertEquals("2018-04-22+05:30", ISO_DATE.format(LocalDate.of(2018, 4, 22)));
//
//        assertEquals("19:58:31", ISO_TIME.format(LocalTime.of(19, 58, 31)));
//        assertEquals("19:58:31+05:30", ISO_TIME.format(LocalTime.of(19, 58, 31)));
//
//        assertEquals(
//                "2018-04-22T19:58:31",
//                ISO_DATE_TIME.format(LocalDateTime.of(2018, 4, 22, 19, 58, 31))
//        );
//        assertEquals(
//                "2018-04-22T19:58:31+05:30",
//                ISO_DATE_TIME.format(LocalDateTime.of(2018, 4, 22, 19, 58, 31))
//        );
//        assertEquals(
//                "2018-04-22T19:58:31+05:30[Asia/Kolkata]",
//                ISO_DATE_TIME.format(LocalDateTime.of(2018, 4, 22, 19, 58, 31))
//        );
//    }
//
//    @Test
//    public void demo_ISOZonedDateTime() {
//        assertEquals(
//                ZonedDateTime.of(LocalDateTime.of(2018, 4, 22, 19, 58, 31), ZoneId.of("Z")),
//                ISO_ZONED_DATE_TIME.parse("2018-04-22T19:58:31+05:30").query(ZonedDateTime::from)
//        );
//        assertEquals(
//                "2018-04-22T19:58:31+05:30[Asia/Kolkata]",
//                ISO_ZONED_DATE_TIME.format(ZonedDateTime.of(LocalDateTime.of(2018, 4, 22, 19, 58, 31), ZoneId.of("Asia/Kolkata")))
//        );
//    }
}
