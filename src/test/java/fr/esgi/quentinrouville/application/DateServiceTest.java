package fr.esgi.quentinrouville.application;

import fr.esgi.quentinrouville.use_case.member.application.DateService;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.Assert.*;

public final class DateServiceTest {
    final DateService dateService = new DateService();

    @Test
    public void testGetCurrentDate() {
        assertEquals(dateService.getCurrentDate(), LocalDate.now().toString());
    }

    @Test
    public void testIsDateInTheFutureMethodWhenTheDateIsInTheFuture() {
        assertTrue(dateService.isDateInTheFuture(LocalDate.now().plusDays(1)));
    }
    @Test
    public void testIsDateInTheFutureMethodWhenTheDateIsInThePast() {
        assertFalse(dateService.isDateInTheFuture(LocalDate.now().minusDays(1)));
    }

    @Test
    public void testIsDateInThePastMethodWhenTheDateIsInThePast() {
        assertTrue(dateService.isDateInThePast(LocalDate.now().minusDays(1)));
    }
    @Test
    public void testIsDateInThePastMethodWhenTheDateIsInTheFuture() {
        assertFalse(dateService.isDateInThePast(LocalDate.now().plusDays(1)));
    }

    @Test
    public void testIsMonthAndYearInTheFutureWhenTheDateIsInTheFuture() {
        assertTrue(dateService.isMonthAndYearInTheFuture(Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR) + 1));
    }
    @Test
    public void testIsMonthAndYearInTheFutureWhenTheDateIsInThePast() {
        assertFalse(dateService.isMonthAndYearInTheFuture(Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR) - 1));
    }

    @Test
    public void testIsMonthAndYearInTheFutureWhenTheDateIsInTheFutureWithTwoDigitYear() {
        assertTrue(dateService.isMonthAndYearInTheFuture(Calendar.getInstance().get(Calendar.MONTH), (Calendar.getInstance().get(Calendar.YEAR) + 1) % 100));
    }
    @Test
    public void testIsMonthAndYearInTheFutureWhenTheDateIsInThePastWithTwoDigitYear() {
        assertFalse(dateService.isMonthAndYearInTheFuture(Calendar.getInstance().get(Calendar.MONTH), (Calendar.getInstance().get(Calendar.YEAR) - 1) % 100));
    }
}
