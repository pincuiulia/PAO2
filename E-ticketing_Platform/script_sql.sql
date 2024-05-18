CREATE TABLE `demo`.`client` (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        username VARCHAR(50) NOT NULL,
                                        password VARCHAR(50) NOT NULL,
                                        emailAddress VARCHAR(100) NOT NULL);

INSERT INTO demo.client VALUES (1, 'POPA Ion', '1234', 'popaion@gmail.com');

CREATE TABLE `demo`.`organizer` (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 username VARCHAR(50) NOT NULL,
                                 password VARCHAR(50) NOT NULL,
                                 emailAddress VARCHAR(100) NOT NULL);

INSERT INTO demo.organizer VALUES (1, 'Caraconcea Mihai', '1234', 'caraconcea@gmail.com');

CREATE TABLE `demo`.`location`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    capacity INT NOT NULL
);

INSERT INTO demo.location VALUES (1, 'Bucuresti', 'fvdfgg', '100');

