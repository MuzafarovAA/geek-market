DROP TABLE IF EXISTS orders_statuses;
CREATE TABLE orders_statuses
(
    id    BIGINT      NOT NULL AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
