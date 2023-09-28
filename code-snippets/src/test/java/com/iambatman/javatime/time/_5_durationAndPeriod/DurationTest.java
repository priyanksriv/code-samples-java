package com.iambatman.javatime.time._5_durationAndPeriod;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DurationTest {

    // About the "units" used to store duration: this class models a quantity or amount of time
    // in terms of seconds and nanoseconds. So we have conversions like toMillis, toHours but
    // getSeconds (no conversion needed).

    // todo: Duration.from(TemporalAmount)

    @Test
    public void demo_Create() {
        // Duration.of
        assertEquals(10, Duration.ofSeconds(10).getSeconds());
        assertEquals(25, Duration.ofMinutes(25).toMinutes());
        assertEquals(11, Duration.of(11, ChronoUnit.HOURS).toHours());
    }

    @Test
    public void demo_DurationParse() {
        // parse time
        assertEquals(15, Duration.parse("PT15M").toMinutes());
        assertEquals(20, Duration.parse("PT20S").getSeconds());
        assertEquals(5341, Duration.parse("PT5.341S").toMillis());
        // parse days
        assertEquals(2, Duration.parse("P2D").toDays());
    }

    @Test
    public void demo_DurationMillisFromInstants() {
        // Duration.between using Instant
        Instant begin = Instant.ofEpochMilli(0);
        Instant end = Instant.ofEpochMilli(1_000_000);
        Duration timeElapsed = Duration.between(begin, end);

        assertEquals(1_000_000, timeElapsed.toMillis());
    }

    @Test
    public void demo_DurationSeconds() {
        // Duration.between using LocalTime
        LocalTime begin = LocalTime.parse("00:00:00");
        LocalTime end = LocalTime.parse("23:59:59");

        Duration timeElapsed = Duration.between(begin, end);
        assertEquals(86_399, timeElapsed.getSeconds());
    }

    @Test
    public void demo_DurationHours() {
        // Duration.between using LocalDateTime
        LocalDateTime begin = LocalDateTime.parse("2018-04-01T00:00:00");
        LocalDateTime end = LocalDateTime.parse("2018-04-03T19:00:00");

        Duration timeElapsed = Duration.between(begin, end);
        assertEquals(67, timeElapsed.toHours());
    }

    @Test
    public void demo_DateTimeException() {
        assertThrows(DateTimeException.class, () -> {
            Instant begin = Instant.ofEpochMilli(0);
            LocalDateTime end = LocalDateTime.parse("1970-01-01T11:59:59");

            Duration.between(begin, end);
        });
    }
}
