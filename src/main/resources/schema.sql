create table if not exists Todo (
    id numeric(4) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(16) NOT NULL,
    tag VARCHAR(20),
    urgency numeric(1)
);