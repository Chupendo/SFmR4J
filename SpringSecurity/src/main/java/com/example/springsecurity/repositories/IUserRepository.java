package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByUserName(String name);
    public boolean existsByUserName(String name);
    public Optional<User> findUserByUserNameAndPassword(String user, String pwd);

    @Query("SELECT u.userName FROM User u")
    public List<String> findAllUserName();

    @Query("SELECT u.userName FROM User u")
    public Page<String> findAllUserNamePage(Pageable page);
}