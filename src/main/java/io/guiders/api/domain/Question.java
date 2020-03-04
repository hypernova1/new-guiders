package io.guiders.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter
public class Question extends Post {

    @ManyToOne
    private User writer;

    @OneToMany
    private List<Answer> answers;

    public void addAnswer(Answer answer) {
        answer.setQuestion(this);
        answers.add(answer);
    }

}
