package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfileRepository extends JpaRepository<Profile,Long> {

    @Query("SELECT p FROM Profile p WHERE p.user.id = ?1 AND p.id = ?2")
    Optional<Profile> findByUserIdAndProfileId(Long idUser,Long idProfile);
}
