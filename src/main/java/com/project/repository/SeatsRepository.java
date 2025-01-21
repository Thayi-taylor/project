package com.project.repository;

import com.project.DTO.SeatsDTO;
import com.project.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Integer> {

    @Query("""
            SELECT new com.project.DTO.SeatsDTO(
                s.seatId, s.rowNumber, s.seatNumber,
                CASE WHEN rs.seats IS NULL THEN 'Available' ELSE 'Reserved' END
            )
            FROM Seats s
            LEFT JOIN ReservedSeats rs ON s = rs.seats
            WHERE s.screens.screenId = :screenId
            ORDER BY s.rowNumber, s.seatNumber
            """)
    List<SeatsDTO> findSeatsByScreenId(int screenId);


}
