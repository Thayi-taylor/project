package com.project.repository;

import com.project.entity.ScreensEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreensRepository extends JpaRepository<ScreensEntity, Integer> {
    List<ScreensEntity> findByTheater_TheaterId(Integer theaterId);
}
