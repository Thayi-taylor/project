package com.project.repository;

import com.project.entity.TheatersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatersRepository extends JpaRepository<TheatersEntity, Integer> {
}
