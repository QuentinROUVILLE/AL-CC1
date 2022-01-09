package fr.esgi.quentinrouville.kernel;

@SuppressWarnings("all")
public interface Entity<VOID extends ValueObjectID> {
    VOID id();
}
