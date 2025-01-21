import React, { useState, useEffect } from "react";
import "./SeatReservation.css"; // 스타일 분리

const SeatReservation = ({ scheduleId }) => {
    const [seats, setSeats] = useState([]);
    const [currentScheduleId, setCurrentScheduleId] = useState(scheduleId || 1);

    // 스케줄 ID 변경 시 좌석 불러오기
    useEffect(() => {
        fetch(`/api/seats?scheduleId=${currentScheduleId}`)
            .then((response) => response.json())
            .then((data) => setSeats(data))
            .catch((error) => console.error("Error fetching seats:", error));
    }, [currentScheduleId]);

    // 좌석 예약 토글
    const toggleSeat = (seatId) => {
        setSeats((prevSeats) =>
            prevSeats.map((seat) =>
                seat.seatId === seatId
                    ? { ...seat, status: seat.status === "available" ? "reserved" : "available" }
                    : seat
            )
        );
    };

    return (
        <div className="container">
            <h2 className="text-center my-4">Schedule ID: {currentScheduleId}</h2>

            {/* 스케줄 ID 변경 입력 */}
            <div className="text-center mb-3">
                <input
                    type="number"
                    value={currentScheduleId}
                    onChange={(e) => setCurrentScheduleId(parseInt(e.target.value) || 1)}
                    className="form-control w-50 d-inline"
                    placeholder="Enter Schedule ID"
                />
                <button className="btn btn-primary" onClick={() => setCurrentScheduleId(currentScheduleId)}>조회</button>
            </div>

            {/* 좌석 테이블 */}
            <div className="table-responsive">
                <table className="seat-table">
                    <tbody>
                    {/* A~K 행 반복 */}
                    {["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"].map((rowLetter) => (
                        <tr key={rowLetter}>
                            {/* 행 이름 박스 */}
                            <td className="row-label">{rowLetter}</td>

                            {/* 좌석 (6 - 공백 - 9 - 공백 - 6) */}
                            {[...Array(21)].map((_, index) => {
                                const seat = seats.find(
                                    (s) => s.rowNumber === rowLetter && s.seatNumber === index + 1
                                );
                                return (
                                    <React.Fragment key={index}>
                                        {index === 6 || index === 15 ? <td className="seat-space"></td> : null}
                                        <td
                                            className={`seat ${seat?.status || "empty"}`}
                                            onClick={() => seat && seat.status === "available" && toggleSeat(seat.seatId)}
                                        >
                                            {seat ? seat.seatNumber : ""}
                                        </td>
                                    </React.Fragment>
                                );
                            })}
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default SeatReservation;
