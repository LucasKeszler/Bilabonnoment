CREATE TABLE medarbejder (
                             medarbejder_id INT AUTO_INCREMENT PRIMARY KEY,
                             username VARCHAR(100) NOT NULL,
                             password VARCHAR(100) NOT NULL,
                             rolle VARCHAR(50) NOT NULL
);

CREATE TABLE kunde (
                       kunde_id INT AUTO_INCREMENT PRIMARY KEY,
                       navn VARCHAR(100),
                       email VARCHAR(100),
                       telefon VARCHAR(20)
);

CREATE TABLE bil (
                     bil_id INT AUTO_INCREMENT PRIMARY KEY,
                     maerke VARCHAR(100),
                     model VARCHAR(100),
                     nummerplade VARCHAR(20),
                     status VARCHAR(50)
);

CREATE TABLE lejeaftale (
                            lejeaftale_id INT AUTO_INCREMENT PRIMARY KEY,
                            kunde_id INT,
                            bil_id INT,
                            startdato DATE,
                            slutdato DATE,
                            pris DOUBLE,
                            status VARCHAR(50)
);

CREATE TABLE skade (
                       skade_id INT AUTO_INCREMENT PRIMARY KEY,
                       bil_id INT,
                       beskrivelse VARCHAR(255),
                       pris DOUBLE
);