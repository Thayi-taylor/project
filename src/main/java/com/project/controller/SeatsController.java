package com.project.controller;

import com.project.DTO.SeatsDTO;
import com.project.service.SeatsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SeatsController {

    private final SeatsService seatsService;

    public SeatsController(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    @GetMapping("/seats")
    public String getSeats(@RequestParam(value = "scheduleId", required = false) Integer scheduleId, Model model) {
        if(scheduleId == null) {
            scheduleId = 1; // 기본값 설정
        }
        List<SeatsDTO> scheduledSeats = seatsService.getSeatsForSchedule(scheduleId);
        model.addAttribute("scheduledSeats", scheduledSeats);
        model.addAttribute("scheduleId", scheduleId);
        return "SeatReservation";
    }
}
