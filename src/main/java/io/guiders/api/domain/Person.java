package io.guiders.api.domain;

import io.guiders.api.domain.audit.DateAudit;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;

@MappedSuperclass
@Getter @Setter
public abstract class Person extends DateAudit {

    @NonNull
    private String name;

    @NonNull
    @Email
    @Column(unique = true)
    private String email;

    @NonNull
    private String password;

}
