package com.iambatman.javatime.threeTen;

import org.junit.jupiter.api.Test;
import org.threeten.extra.AmPm;
import org.threeten.extra.Interval;
import org.threeten.extra.Quarter;
import org.threeten.extra.YearQuarter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ThreeTenTest {

    @Test
    public void demo_AmPm() {
        // getValue
        assertEquals(0, AmPm.AM.getValue());
        assertEquals(1, AmPm.PM.getValue());
        // AmPm.ofHour
        assertEquals(AmPm.AM, AmPm.ofHour(11));
        assertEquals(AmPm.PM, AmPm.ofHour(21));
        // AmPm.from
        assertEquals(AmPm.AM, AmPm.from(LocalTime.of(11, 15)));
    }

    @Test
    public void demo_Quarter() {
        // getValue
        assertEquals(1, Quarter.Q1.getValue());
        assertEquals(2, Quarter.Q2.getValue());
        // Quarter.of
        assertEquals(Quarter.Q3, Quarter.of(3));
        assertEquals(Quarter.Q4, Quarter.of(4));
        // Quarter.ofMonth
        assertEquals(Quarter.Q1, Quarter.ofMonth(2));
        assertEquals(Quarter.Q3, Quarter.ofMonth(7));
        assertEquals(Quarter.Q4, Quarter.ofMonth(12));
        // first month of quarter
        assertEquals(Month.APRIL, Quarter.Q2.firstMonth());
        assertEquals(Month.OCTOBER, Quarter.Q4.firstMonth());

        // ?? No lastMonth implementation ??
    }

    @Test
    public void demo_YearQuarter() {
        // YearQuarter.now
        YearQuarter yearQuarterNow = YearQuarter.now();
        System.out.println(String.format("YearQuarter current: (Year Quarter) = (%s, %s) ",
                yearQuarterNow.getYear(), yearQuarterNow.getQuarter()));

        // length of quarter
        assertEquals(90, YearQuarter.of(2018, Quarter.Q1).lengthOfQuarter());
        // end of quarter
        assertEquals(LocalDate.parse("2018-09-30"), YearQuarter.of(2018, 3).atEndOfQuarter());
        // YearQuarter.parse
        assertEquals(YearQuarter.of(2018, Quarter.Q4), YearQuarter.parse("2018-Q4"));
    }

    @Test
    public void demo_PeriodDuration() {

    }

    @Test
    public void demo_IntervalIntro() {
        Interval i1 = Interval.of(
                Instant.parse("1970-01-01T00:00:00.00Z"),
                Instant.parse("1970-05-01T00:00:00.00Z"));

        // Interval.toDuration
        assertEquals(120, i1.toDuration().toDays());

        // Interval.contains
        assertEquals(true, i1.contains(Instant.parse("1970-04-01T00:00:00.00Z")));

        // Interval.encloses
        Interval i2 = Interval.of(
                Instant.parse("1970-01-01T01:00:00.00Z"),
                Instant.parse("1970-04-30T23:59:00.00Z"));
        Interval i3 = Interval.of(
                Instant.parse("1970-01-01T01:00:00.00Z"),
                Instant.parse("1970-05-02T23:59:00.00Z"));

        assertEquals(true, i1.encloses(i2));
        assertEquals(false, i1.encloses(i3));
    }

    @Test
    public void demo_IntervalConnection() {
        Interval i1 = Interval.of(
                Instant.parse("1970-01-01T00:00:00.00Z"),
                Instant.parse("1970-05-01T00:00:00.00Z"));

        // Interval.abuts
        // Interval.overlaps
        // Interval.isConnected
        // Interval.intersection
        // Interval.union
    }
}
