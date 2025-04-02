package io.github.dursunkoc.mycustomerservice.domain;

import io.github.dursunkoc.mycustomerservice.enums.CustomerContactType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
public final class CustomerContactGsm extends CustomerContact{
    private final String gsmNo;
    public CustomerContactGsm(String gsmNo) {
        super(CustomerContactType.GSM);
        this.gsmNo = gsmNo;
    }
}
