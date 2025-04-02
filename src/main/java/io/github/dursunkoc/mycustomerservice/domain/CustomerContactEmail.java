package io.github.dursunkoc.mycustomerservice.domain;


import io.github.dursunkoc.mycustomerservice.enums.CustomerContactType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
public final class CustomerContactEmail extends CustomerContact {
    private final String email;

    public CustomerContactEmail(String email) {
        super(CustomerContactType.EMAIL);
        this.email = email;
    }
}
