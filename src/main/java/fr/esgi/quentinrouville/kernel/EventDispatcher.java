package fr.esgi.quentinrouville.kernel;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
