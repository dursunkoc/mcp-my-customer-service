package io.github.dursunkoc.mycustomerservice.domain;

import io.github.dursunkoc.mycustomerservice.enums.Gender;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@RequiredArgsConstructor
public class CustomerDemographics {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final Gender gender;
    private final String occupation;
}
