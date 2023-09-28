package com.iambatman.javatime.time._4_instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.UnsupportedTemporalTypeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstantTest {

    //  Instant class:
    //  - models a single instantaneous point on the time-line.
    //  - used to record event time-stamps in the application.
    //  - stores a long representing epoch-seconds and an int representing nanosecond-of-second
    @Test
    public void demo_InstantNow() {
        // now
        Instant now = Instant.now();
        System.out.println("Second: " + now.getEpochSecond() + ", Nano: " + now.getNano());
        System.out.println("To Epoch milli: " + now.toEpochMilli());
    }


    // Instant is intended for use only by a machine. Hence, it doesn’t provide any ability
    // to handle units of time that are meaningful to humans.
    @Test
    public void demo_UnsupportedTemporalType() {
        assertThrows(UnsupportedTemporalTypeException.class, () -> {
            Instant.now().get(ChronoField.SECOND_OF_DAY);
        });
    }

    @Test
    public void demo_InstantParse() {
        assertEquals(
                Instant.from(LocalDateTime.of(2018, 4, 22, 19, 58, 31).atZone(ZoneId.of("Z"))),
                Instant.parse("2018-04-22T19:58:31Z")
        );
    }
}
