package io.guiders.api.domain;

import io.guiders.api.domain.audit.DateAudit;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

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

    @OneToMany
    private List<Question> questions;

    @OneToMany
    private List<Answer> answers;

    public void addQuestion(Question question) {
        question.setWriter(this);
        questions.add(question);
    }

    public void addAnswer(Answer answer) {
        answer.setWriter(this);
        answers.add(answer);
    }

}
