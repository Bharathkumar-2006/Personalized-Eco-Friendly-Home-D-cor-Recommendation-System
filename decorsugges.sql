CREATE DATABASE decorsugges;
USE decorsugges;

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    preferences TEXT,
    budget DECIMAL(10, 2)
);


CREATE TABLE Brands (
    brand_id INT PRIMARY KEY AUTO_INCREMENT,
    brand_name VARCHAR(100) NOT NULL,
    eco_friendly BOOLEAN NOT NULL
);


CREATE TABLE DécorItems (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    eco_friendly BOOLEAN NOT NULL,
    brand_id INT,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES Brands(brand_id)
);


CREATE TABLE Reviews (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    item_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review_text TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (item_id) REFERENCES DécorItems(item_id)
);


CREATE TABLE RoomDimensions (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    length DECIMAL(5, 2),
    width DECIMAL(5, 2),
    height DECIMAL(5, 2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);