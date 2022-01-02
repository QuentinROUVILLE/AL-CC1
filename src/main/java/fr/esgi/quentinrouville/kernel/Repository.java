package fr.esgi.quentinrouville.kernel;

import java.util.NoSuchElementException;

public interface Repository<VOID, E> {
    VOID nextIdentity();

    E findById(VOID id) throws NoSuchElementException;

    void save(E entity);
}
