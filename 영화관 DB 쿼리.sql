-- 영화 예매 시스템 데이터베이스 설계

CREATE schema THEATER;
USE THEATER;
-- 영화관 정보
CREATE TABLE Theaters (
    TheaterID INT AUTO_INCREMENT PRIMARY KEY,
    TheaterName VARCHAR(255) NOT NULL,
    Location VARCHAR(255) NOT NULL,
    ContactInfo VARCHAR(255)
);

-- 상영관 정보
CREATE TABLE Screens (
    ScreenID INT AUTO_INCREMENT PRIMARY KEY,
    TheaterID INT NOT NULL,
    ScreenName VARCHAR(255) NOT NULL,
    TotalSeats INT NOT NULL,
    FOREIGN KEY (TheaterID) REFERENCES Theaters(TheaterID) ON DELETE CASCADE
);

-- 좌석 정보
CREATE TABLE Seats (
    SeatID INT AUTO_INCREMENT PRIMARY KEY,
    ScreenID INT NOT NULL,
    RowNumber CHAR(1) NOT NULL, -- A, B, C 등
    SeatNumber INT NOT NULL,    -- 1, 2, 3 등
    FOREIGN KEY (ScreenID) REFERENCES Screens(ScreenID) ON DELETE CASCADE,
    UNIQUE(ScreenID, RowNumber, SeatNumber)
);

-- 좌석 자동 삽입 트리거 생성
DELIMITER $$
CREATE TRIGGER InsertSeatsForScreen
AFTER INSERT ON Screens
FOR EACH ROW
BEGIN
    DECLARE RowNumber CHAR(1);
    DECLARE SeatNumber INT;

    SET RowNumber = 'A';
    WHILE RowNumber <= 'K' DO
        SET SeatNumber = 1;
        WHILE SeatNumber <= 21 DO
            INSERT INTO Seats (ScreenID, RowNumber, SeatNumber) VALUES (NEW.ScreenID, RowNumber, SeatNumber);
            SET SeatNumber = SeatNumber + 1;
        END WHILE;
        SET RowNumber = CHAR(ASCII(RowNumber) + 1);
    END WHILE;
END $$
DELIMITER ;

-- 영화 정보
CREATE TABLE Movies (
    MovieID INT AUTO_INCREMENT PRIMARY KEY,
    MovieTitle VARCHAR(255) NOT NULL,
    MovieGenre VARCHAR(255),
    MovieDuration INT NOT NULL, -- 영화 상영 시간 (분)
    MovieReleaseDate DATE,
    MovieAgeRating INT NOT NULL
);

-- 상영 일정
CREATE TABLE Schedules (
    ScheduleID INT AUTO_INCREMENT PRIMARY KEY,
    ScreenID INT NOT NULL,
    MovieID INT NOT NULL,
    MovieShowDate DATE NOT NULL,
    MovieStartTime TIME NOT NULL,
    MovieDuration INT NOT NULL,
    MovieEndTime TIME GENERATED ALWAYS AS (ADDTIME(MovieStartTime, SEC_TO_TIME(MovieDuration * 60))) STORED,
    FOREIGN KEY (ScreenID) REFERENCES Screens(ScreenID) ON DELETE CASCADE,
    FOREIGN KEY (MovieID) REFERENCES Movies(MovieID) ON DELETE CASCADE
);

-- 예약 정보
CREATE TABLE Reservations (
    ReservationID INT AUTO_INCREMENT PRIMARY KEY,
    ScheduleID INT NOT NULL,
    CustomerName VARCHAR(255) NOT NULL,
    CustomerContact VARCHAR(255),
    TotalPrice DECIMAL(10, 2) NOT NULL,
    ReservationDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ScheduleID) REFERENCES Schedules(ScheduleID) ON DELETE CASCADE
);

-- 예약된 좌석
CREATE TABLE ReservedSeats (
    ReservedSeatID INT AUTO_INCREMENT PRIMARY KEY,
    ReservationID INT NOT NULL,
    SeatID INT NOT NULL,
    SeatPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ReservationID) REFERENCES Reservations(ReservationID) ON DELETE CASCADE,
    FOREIGN KEY (SeatID) REFERENCES Seats(SeatID) ON DELETE CASCADE
);

-- 할인 정보
CREATE TABLE Discounts (
    DiscountID INT AUTO_INCREMENT PRIMARY KEY,
    Description VARCHAR(255),
    DiscountRate DECIMAL(5, 2) NOT NULL, -- 할인율 (예: 20%)
    DiscountStartTime TIME NOT NULL,
    DiscountEndtime TIME NOT NULL
);

-- 예약에 적용된 할인
CREATE TABLE AppliedDiscounts (
    AppliedDiscountID INT AUTO_INCREMENT PRIMARY KEY,
    ReservationID INT NOT NULL,
    DiscountID INT NOT NULL,
    FOREIGN KEY (ReservationID) REFERENCES Reservations(ReservationID) ON DELETE CASCADE,
    FOREIGN KEY (DiscountID) REFERENCES Discounts(DiscountID) ON DELETE CASCADE
);


-- DROP EVENT CopySchedulesEveryHour;
-- 상영 일정 복사 이벤트 생성
SET GLOBAL event_scheduler = ON;

DELIMITER $$
CREATE EVENT CopySchedulesEveryHour
ON SCHEDULE EVERY 1 MINUTE
DO
BEGIN
    DECLARE StartDate DATE DEFAULT '2025-01-01';
    DECLARE EndDate DATE DEFAULT '2025-02-15';

    INSERT INTO Schedules (ScreenID, MovieID, MovieShowDate, MovieStartTime, MovieDuration)
    SELECT ScreenID, MovieID, DATE_ADD(MovieShowDate, INTERVAL 7 DAY), MovieStartTime, MovieDuration
    FROM Schedules
    WHERE DATE_ADD(MovieShowDate, INTERVAL 7 DAY) BETWEEN StartDate AND EndDate
      AND NOT EXISTS (
          SELECT 1 FROM Schedules AS s2
          WHERE s2.ScreenID = Schedules.ScreenID
          AND s2.MovieID = Schedules.MovieID
          AND s2.MovieShowDate = DATE_ADD(Schedules.MovieShowDate, INTERVAL 7 DAY)
          AND s2.MovieStartTime = Schedules.MovieStartTime
      );
END $$theaters
DELIMITER ;

INSERT INTO Theaters (theaterName, Location, ContactInfo) VALUES ('CGV영등포', '서울특별시 영등포구 영중로 15 타임스퀘어 4F', '1544-1122');
INSERT INTO Screens (theaterID, ScreenName, TotalSeats) VALUES ('1', '1관', '231');
INSERT INTO movies (MovieTitle, MovieGenre, MovieDuration, MovieReleaseDate, MovieAgeRating) VALUES ('하얼빈', '역사', '114', '20241224', '15');
INSERT INTO Discounts (Description, DiscountRate, DiscountStartTime, DiscountEndtime) VALUES ('조조할인', '20', '04:00:00', '10:00:00');
INSERT INTO Discounts (Description, DiscountRate, DiscountStartTime, DiscountEndtime) VALUES ('심야할인', '20', '22:00:00', '04:00:00');

INSERT INTO Schedules (ScreenID, MovieID, MovieShowDate, MovieStartTime, MovieDuration)
VALUES (1, 1, '2025-01-16', '10:30:00', 114);
INSERT INTO Schedules (ScreenID, MovieID, MovieShowDate, MovieStartTime, MovieDuration)
VALUES (1, 1, '2025-01-16', '13:00:00', 114);
INSERT INTO Schedules (ScreenID, MovieID, MovieShowDate, MovieStartTime, MovieDuration)
VALUES (1, 1, '2025-01-16', '15:30:00', 114);
INSERT INTO Schedules (ScreenID, MovieID, MovieShowDate, MovieStartTime, MovieDuration)
VALUES (1, 1, '2025-01-16', '18:00:00', 114);
INSERT INTO Schedules (ScreenID, MovieID, MovieShowDate, MovieStartTime, MovieDuration)
VALUES (1, 1, '2025-01-16', '20:30:00', 114);
INSERT INTO Schedules (ScreenID, MovieID, MovieShowDate, MovieStartTime, MovieDuration)
VALUES (1, 1, '2025-01-16', '23:00:00', 114);
