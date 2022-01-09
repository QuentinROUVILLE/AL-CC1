package fr.esgi.quentinrouville.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}
