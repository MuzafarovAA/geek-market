DROP TABLE IF EXISTS delivery_addresses;
CREATE TABLE delivery_addresses
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    user_id BIGINT      NOT NULL,
    address VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_delivery_addresses_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
