package com.example.springsecurity.entities;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class AuditDetails {

    @NonNull private String createdBy;
    @NonNull private String roleName;

    public AuditDetails(){}
}
