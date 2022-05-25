DROP TABLE IF EXISTS categories;
CREATE TABLE categories
(
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(45) NOT NULL,
    description VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
