package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.UserToRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToRoleRepository extends JpaRepository<UserToRole,Long> {
}
