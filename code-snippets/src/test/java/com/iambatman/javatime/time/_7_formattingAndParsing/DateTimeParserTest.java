package com.iambatman.javatime.time._7_formattingAndParsing;

import org.junit.jupiter.api.Test;

import java.time.*;

import static java.time.format.DateTimeFormatter.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DateTimeParserTest {

    @Test
    public void demo_BasicISODate() {
        assertEquals(LocalDate.of(2018, 4, 22), BASIC_ISO_DATE.parse("20180422").query(LocalDate::from));
    }

    @Test
    public void demo_ISOLocal() {
        assertEquals(LocalDate.of(2018, 4, 22), ISO_LOCAL_DATE.parse("2018-04-22").query(LocalDate::from));
        assertEquals(LocalTime.of(19, 58, 31), ISO_LOCAL_TIME.parse("19:58:31").query(LocalTime::from));

        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                ISO_LOCAL_DATE_TIME.parse("2018-04-22T19:58:31").query(LocalDateTime::from)
        );
    }

    @Test
    public void demo_ISOOffset() {
        assertEquals(LocalDate.of(2018, 4, 22), ISO_OFFSET_DATE.parse("2018-04-22+05:30").query(LocalDate::from));
        assertEquals(LocalTime.of(19, 58, 31), ISO_OFFSET_TIME.parse("19:58:31+05:30").query(LocalTime::from));

        assertEquals(
                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
                ISO_OFFSET_DATE_TIME.parse("2018-04-22T19:58:31+05:30").query(LocalDateTime::from)
        );
    }

    @Test
    public void demo_ISOInstant() {
        assertEquals(
                Instant.from(LocalDateTime.of(2018, 4, 22, 19, 58, 31).atZone(ZoneId.of("Z"))),
                ISO_INSTANT.parse("2018-04-22T19:58:31Z").query(Instant::from)
        );
    }

//    @Test
//    public void demo_ISOWithOptionalZones() {
//        assertEquals(LocalDate.of(2018, 4, 22), ISO_DATE.parse("2018-04-22").query(LocalDate::from));
//        assertEquals(LocalDate.of(2018, 4, 22), ISO_DATE.parse("2018-04-22+05:30").query(LocalDate::from));
//
//        assertEquals(LocalTime.of(19, 58, 31), ISO_TIME.parse("19:58:31").query(LocalTime::from));
//        assertEquals(LocalTime.of(19, 58, 31), ISO_TIME.parse("19:58:31+05:30").query(LocalTime::from));
//
//        assertEquals(
//                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
//                ISO_DATE_TIME.parse("2018-04-22T19:58:31").query(LocalDateTime::from)
//        );
//        assertEquals(
//                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
//                ISO_DATE_TIME.parse("2018-04-22T19:58:31+05:30").query(LocalDateTime::from)
//        );
//        assertEquals(
//                LocalDateTime.of(2018, 4, 22, 19, 58, 31),
//                ISO_DATE_TIME.parse("2018-04-22T19:58:31+05:30[Asia/Kolkata]").query(LocalDateTime::from)
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
//                ZonedDateTime.of(LocalDateTime.of(2018, 4, 22, 19, 58, 31), ZoneId.of("Asia/Kolkata")),
//                ISO_ZONED_DATE_TIME.parse("2018-04-22T19:58:31+05:30[Asia/Kolkata]").query(ZonedDateTime::from)
//        );
//    }
}
