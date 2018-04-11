package com.warson.warsonbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.warson.warsonbe.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long idd);
    
    @Query("SELECT u FROM User u where u.id=:id")
    User findByUserId(@Param("id") Long id);
    
    List<User> findByIdIn(List<Long> ids);

    List<User> findByIdIn(List<Long> ids, Sort sort);
}
