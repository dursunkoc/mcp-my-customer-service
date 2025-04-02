package io.github.dursunkoc.mycustomerservice.enums;

public enum Gender {
    MALE, FEMALE;

    public static Gender of(String gender) {
        return switch (gender.toUpperCase()) {
            case "MALE", "M", "ERKEK", "E" -> MALE;
            case "FEMALE", "F", "KADIN", "K" -> FEMALE;
            default -> throw new IllegalArgumentException("Invalid gender: " + gender);
        };
    }
}
