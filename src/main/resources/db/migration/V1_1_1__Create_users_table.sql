DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    users      VARCHAR(45) NOT NULL,
    password   CHAR(255)   NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name  VARCHAR(45) NOT NULL,
    email      VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
