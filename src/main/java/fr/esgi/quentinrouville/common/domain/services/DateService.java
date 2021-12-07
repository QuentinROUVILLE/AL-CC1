package fr.esgi.quentinrouville.common.domain.services;

import java.time.LocalDate;
import java.util.Calendar;

public final class DateService
{
    public String getCurrentDate() {
        return LocalDate.now().toString();
    }

    public boolean isDateInTheFuture(LocalDate date){
        return date.isAfter(LocalDate.now());
    }

    public boolean isDateInThePast(LocalDate date){
        return date.isBefore(LocalDate.now());
    }

    public boolean isMonthAndYearInTheFuture(int month, int year){
        year = reformateYear(year);
        return isDateInTheFuture(LocalDate.of(year, month, 1));
    }

    private int reformateYear(int year){
        if(year < 2000){
            return year + (Calendar.getInstance().get(Calendar.YEAR) / 100) * 100;
        }
        return year;
    }
}