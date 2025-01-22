package com.project.repository;

import com.project.DTO.SeatsDTO;
import com.project.entity.SeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<SeatsEntity, Integer> {

    @Query("""
       SELECT new com.project.DTO.SeatsDTO(
           s.seatId, s.rowNumber, s.seatNumber,
           CASE WHEN rs.bookedSeat IS NULL THEN 'Available' ELSE 'Booked' END
       )
       FROM SeatsEntity s
       LEFT JOIN ReservedSeatEntity rs ON s = rs.bookedSeat
       WHERE s.screenRef.screenId = :screenId
       ORDER BY s.rowNumber, s.seatNumber
       """)
    List<SeatsDTO> findSeatsByScreenId(int screenId);

}
