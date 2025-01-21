package com.project.repository;

import com.project.entity.SeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<SeatsEntity, Integer> {
    List<SeatsEntity> findByScreen_ScreenId(Integer screenId);

    List<SeatsEntity> findByScreen_Theater_TheaterId(Integer theaterId);

    SeatsEntity findByScreen_ScreenIdAndRowNumberAndSeatNumber(Integer screenId, String rowNumber, Integer seatNumber);
}
