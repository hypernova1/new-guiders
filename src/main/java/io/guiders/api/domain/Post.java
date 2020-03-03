package io.guiders.api.domain;

import io.guiders.api.domain.audit.DateAudit;
import io.guiders.api.domain.constant.PostType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@ToString
public class Post extends DateAudit {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    @ManyToOne
    private Guider writer;

    private PostType postType;


}
