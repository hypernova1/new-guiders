package io.guiders.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("G")
@Getter @Setter
public class Guider extends User {

    @OneToMany
    private List<Essay> essays;

    public void addEssay(Essay essay) {
        essay.setGuider(this);
        essays.add(essay);
    }

}
