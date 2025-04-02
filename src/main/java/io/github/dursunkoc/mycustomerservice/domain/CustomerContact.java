package io.github.dursunkoc.mycustomerservice.domain;

import io.github.dursunkoc.mycustomerservice.enums.CustomerContactType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract sealed class CustomerContact permits CustomerContactGsm, CustomerContactEmail {
    private final CustomerContactType type;
}
