package io.guiders.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
public class Answer extends Post {

    @ManyToOne
    private User writer;

    @ManyToOne
    private Question question;
}
