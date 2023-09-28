package com.iambatman.javatime.time._5_durationAndPeriod;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PeriodTest {

    // todo: Period.from(TemporalAmount)

    @Test
    public void demo_Create() {
        // Period.of
        assertEquals(10, Period.ofDays(10).getDays());
        assertEquals(21, Period.ofWeeks(3).getDays());

        Period period = Period.of(4, 6, 1);
        assertEquals(4, period.getYears());
        assertEquals(6, period.getMonths());
        assertEquals(1, period.getDays());
    }

    @Test
    public void demo_DurationParse() {
        // parse
        assertEquals(2, Period.parse("P2Y").getYears());
        assertEquals(3, Period.parse("P3M").getMonths());
        assertEquals(Period.of(1, 2, 3), Period.parse("P1Y2M3D"));
        assertEquals(Period.of(1, 2, 25), Period.parse("P1Y2M3W4D"));
    }


    // Period: amount of time with date-based value, in terms of years, months, and days
    @Test
    public void demo_PeriodDays() {
        // Period.between using LocalDate
        LocalDate begin = LocalDate.parse("2017-01-01");
        LocalDate end = LocalDate.parse("2018-03-25");

        Period period = Period.between(begin, end);
        assertEquals(1, period.getYears());
        assertEquals(2, period.getMonths());
        assertEquals(24, period.getDays());
    }


    // ChronoUnit.between : amount of time in a single unit of time only, such as days or seconds.
    // ChronoUnit : enum that defines the units used to measure time like MILLIS, SECONDS, DAYS, etc

    @Test
    public void demo_ChronoUnitMillis() {
        // Period.between using ChronoUnit.MILLIS
        Instant begin = Instant.ofEpochSecond(0);
        Instant end = Instant.ofEpochSecond(78_445, 5_000_000);

        long millis = ChronoUnit.MILLIS.between(begin, end);
        assertEquals(78_445_005, millis);
    }

    @Test
    public void demo_ChronoUnitDays() {
        // Period.between using ChronoUnit.DAYS
        LocalDate begin = LocalDate.parse("2018-01-01");
        LocalDate end = LocalDate.parse("2018-03-31");

        long days = ChronoUnit.DAYS.between(begin, end);
        assertEquals(89, days);
    }
}
