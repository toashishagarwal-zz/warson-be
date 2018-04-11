package com.warson.warsonbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.warson.warsonbe.models.Wish;

@Repository
public interface WishesRepository extends JpaRepository<Wish, Long> {
    Optional<Wish> findById(Long id);

    List<Wish> findByIdIn(List<Long> ids);

    List<Wish> findByIdIn(List<Long> ids, Sort sort);
    
    List<Wish> findAll();
    
    @Query("SELECT w FROM Wish w where w.status=:statusId")
    List<Wish> findByStatusId(@Param("statusId") Integer statusId);
}
