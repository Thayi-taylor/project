import { useState, useEffect } from "react";

// 좌석 데이터 로드 & 토글 함수
export const useSeats = (initialScheduleId = 1) => {
    const [seats, setSeats] = useState([]);
    const [currentScheduleId, setCurrentScheduleId] = useState(initialScheduleId);

    // 좌석 데이터 불러오기
    useEffect(() => {
        fetchSeats(currentScheduleId);
    }, [currentScheduleId]);

    const fetchSeats = (scheduleId) => {
        fetch(`/api/seats?scheduleId=${scheduleId}`)
            .then((response) => response.json())
            .then((data) => setSeats(data))
            .catch((error) => console.error("Error fetching seats:", error));
    };

    const toggleSeat = (seatId) => {
        setSeats((prevSeats) =>
            prevSeats.map((seat) =>
                seat.seatId === seatId
                    ? { ...seat, status: seat.status === "available" ? "reserved" : "available" }
                    : seat
            )
        );
    };

    return { seats, currentScheduleId, setCurrentScheduleId, toggleSeat };
};
