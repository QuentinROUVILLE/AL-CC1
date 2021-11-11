package fr.esgi.quentinrouville.common.domain.model;

public final class MemberId
{
    private final int value;

    private MemberId (int value) {
        this.value = value;
    }

    public static MemberId of(int value) {
        return new MemberId(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
