package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.User;
import com.example.springsecurity.entities.UserToRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserToRoleRepository extends JpaRepository<UserToRole,Long> {

    @Query("SELECT u.user from UserToRole u WHERE u.role.name=?1")
    public List<User> findUserByRoleName(String roleName);

    //@Query("SELECT u FROM UserToRole u WHERE u.user = ?1")
    List<UserToRole> findByUser(User user);
}
