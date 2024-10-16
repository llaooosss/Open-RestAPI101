CREATE TABLE films (
    id INT PRIMARY KEY,
    filmId INT NOT NULL UNIQUE,
    filmName VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    rating DECIMAL(2, 1),
    description TEXT
);
