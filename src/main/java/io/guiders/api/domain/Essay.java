package io.guiders.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
public class Essay extends Post {

    @ManyToOne
    private Guider guider;

    private int likeCnt;

    private int scrapCnt;

}
