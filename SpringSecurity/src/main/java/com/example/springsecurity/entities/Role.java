package com.example.springsecurity.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="role")
@Data
@ToString
@EqualsAndHashCode(exclude = "id")
@RequiredArgsConstructor //create a constructor with nonnull attr  only
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=0L;

    @Column(name="name",nullable = false,unique = true)
    @NonNull private String name;

    public Role(){}

    public Role(Long id,@NonNull String name){
        this.id = id;
        this.name=name;
    }
    public Role(Role role){
        this.id=role.getId();
        this.name=role.getName();
    }
}
