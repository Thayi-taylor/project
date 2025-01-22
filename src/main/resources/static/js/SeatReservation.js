import React, { useState, useEffect } from "react";
import "./SeatReservation.css"; // 스타일 분리

const SeatReservation = ({ scheduleId }) => {
    const [seats, setSeats] = useState([]);
    const [currentScheduleId, setCurrentScheduleId] = useState(scheduleId || 1);
    const [selectedSeats, setSelectedSeats] = useState(new Set()); // ✅ 선택한 좌석 저장

    // 스케줄 ID 변경 시 좌석 불러오기
    useEffect(() => {
        fetch(`/api/seats?scheduleId=${currentScheduleId}`)
            .then((response) => response.json())
            .then((data) => {
                setSeats(data);
                setSelectedSeats(new Set()); // ✅ 스케줄 변경 시 선택 초기화
            })
            .catch((error) => console.error("Error fetching seats:", error));
    }, [currentScheduleId]);

    // 좌석 선택/해제
    const toggleSeat = (seatId) => {
        setSelectedSeats((prevSelectedSeats) => {
            const newSelectedSeats = new Set(prevSelectedSeats);
            if (newSelectedSeats.has(seatId)) {
                newSelectedSeats.delete(seatId); // 선택 취소
            } else {
                newSelectedSeats.add(seatId); // 선택 추가
            }
            return newSelectedSeats;
        });
    };

    // 예약 요청
    const handleReserveSeats = () => {
        if (selectedSeats.size === 0) {
            alert("좌석을 선택해주세요!");
            return;
        }

        fetch("/api/reserve", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ seats: Array.from(selectedSeats), scheduleId: currentScheduleId })
        })
            .then(response => response.json())
            .then(data => {
                alert(data.message);
                setSelectedSeats(new Set()); // ✅ 예약 후 선택 초기화
                setSeats(seats.map(seat => ({
                    ...seat,
                    status: selectedSeats.has(seat.seatId) ? "reserved" : seat.status // ✅ 서버 응답 반영
                })));
            })
            .catch(error => console.error("Error reserving seats:", error));
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
                                            className={`seat ${seat?.status || "empty"} ${selectedSeats.has(seat?.seatId) ? "selected" : ""}`}
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

            {/* ✅ 예약 버튼 추가 */}
            <div className="text-center mt-3">
                <button className="btn btn-success" onClick={handleReserveSeats}>예약하기</button>
            </div>
        </div>
    );
};

export default SeatReservation;
