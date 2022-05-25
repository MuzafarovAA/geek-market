DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
    id                  BIGINT      NOT NULL AUTO_INCREMENT,
    user_id             BIGINT      NOT NULL,
    status_id           BIGINT      NOT NULL,
    price               DOUBLE      NOT NULL,
    delivery_price      DOUBLE      NOT NULL,
    delivery_address_id BIGINT      NOT NULL,
    phone_number        VARCHAR(45) NOT NULL,
    delivery_date       TIMESTAMP   NOT NULL,
    create_at           TIMESTAMP   NOT NULL,
    update_at           TIMESTAMP   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_orders_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `fk_orders_status_id` FOREIGN KEY (`status_id`) REFERENCES `orders_statuses` (`id`),
    CONSTRAINT `fk_orders_delivery_address_id` FOREIGN KEY (`delivery_address_id`) REFERENCES `delivery_addresses` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
