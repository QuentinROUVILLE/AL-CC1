package fr.esgi.quentinrouville.services;

import fr.esgi.quentinrouville.common.domain.services.DateService;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.*;

public final class DateServiceTests {
    DateService dateService = new DateService();

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
}
