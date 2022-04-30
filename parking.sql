create database parking_system;
use parking_system;
create table parking(id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
uname VARCHAR(30), mobile_no  VARCHAR(10), bank_balance INT,
vehicle_type INT, modal_number INT, manufacturer VARCHAR(30),
car_number  VARCHAR(10), entry_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP, alloted_time INT);