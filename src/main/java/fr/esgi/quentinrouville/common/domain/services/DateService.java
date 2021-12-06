package fr.esgi.quentinrouville.common.domain.services;

import java.time.LocalDate;

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
}