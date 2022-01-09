package fr.esgi.quentinrouville.use_case.member.exposition;

public final class PasswordDTO {
    public final String password;

    private PasswordDTO(String password) {
        this.password = password;
    }

    public static PasswordDTO of(String password) {
        return new PasswordDTO(password);
    }

    @Override
    public String toString() {
        return "PasswordDTO{" +
                "password='" + password + '\'' +
                '}';
    }
}
