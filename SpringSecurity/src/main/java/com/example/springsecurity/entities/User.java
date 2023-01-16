package com.example.springsecurity.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
@ToString
@EqualsAndHashCode(exclude = {"id","nick","password","role"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Column(name="name")
    @NonNull private String userName;

    @Column(name="nick")
    @NonNull private String userNick;

    @Column(name="password")
    @NonNull private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(){}

    public User(User user){
        this.id=user.getId();
        this.userName=user.getUserName();
        this.userNick=user.getUserNick();
        this.password=user.getPassword();
        this.role=user.getRole();
    }
}
