package io.github.dursunkoc.mycustomerservice.domain;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String identityKey;
    private List<CustomerContact> customerContacts;
    private CustomerDemographics customerDemographics;
}
