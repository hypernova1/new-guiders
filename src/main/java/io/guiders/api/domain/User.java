package io.guiders.api.domain;

import io.guiders.api.domain.audit.DateAudit;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@Getter @Setter
public abstract class User extends DateAudit {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Email
    @Column(unique = true)
    private String email;

    @NonNull
    private String password;

}
