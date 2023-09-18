package com.example.testquartz.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "USER_INFO")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "USER_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FOLLOWERS")
    private long followers;

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', followers=%d}", id, name, followers);
    }

}
