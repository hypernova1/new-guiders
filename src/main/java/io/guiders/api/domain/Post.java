package io.guiders.api.domain;

import io.guiders.api.domain.audit.DateAudit;
import io.guiders.api.domain.constant.PostType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Getter @Setter
public abstract class Post extends DateAudit {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
