package io.guiders.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("F")
@Getter @Setter
public class Follower extends User {

}
