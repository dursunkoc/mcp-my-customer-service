package io.github.dursunkoc.mycustomerservice.domain;

import java.time.LocalDate;

public record CustomerWrite(String identityKey, String firstName, String lastName,
                            LocalDate birthDate, String gender, String occupation, String gsmNo, String email) {
}
