import React from "react";
import { useSeats } from "./seatFunctions";
import "./styles.css"; // 스타일 유지

const SeatReservation = ({ scheduleId }) => {
    const { seats, currentScheduleId, setCurrentScheduleId, toggleSeat } = useSeats(scheduleId);

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
                            <td className="row-label">{rowLetter}</td>

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
