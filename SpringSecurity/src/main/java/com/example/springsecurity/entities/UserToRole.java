package com.example.springsecurity.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user_in_role")
@Data
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class UserToRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @NonNull private User user;

    @ManyToOne
    @JoinColumn(name="role_id",referencedColumnName = "id")
    @NonNull private Role role;

    public UserToRole(){}
    public UserToRole(User user, Role role){
        this.user = user;
        this.role = role;
    }
}
