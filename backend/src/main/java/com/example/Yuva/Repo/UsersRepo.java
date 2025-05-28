package com.example.Yuva.Repo;

import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    Optional<Users> findById(Long id);

    @Query("SELECT u FROM Users u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<UsersDto> searchByName(@Param("query") String query);

    @Query("SELECT u FROM Users u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<UsersDto> searchByUsername(@Param("query") String query);
}
