package com.project.repository;

import com.project.entity.SeatsGradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsGradeRepository extends JpaRepository<SeatsGradeEntity, Integer> {
}
