DROP TABLE IF EXISTS orders_item;
CREATE TABLE orders_item
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    quantity    BIGINT NOT NULL,
    item_price  DOUBLE NOT NULL,
    total_price DOUBLE NOT NULL,
    product_id  BIGINT NOT NULL,
    order_id    BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_orders_item_product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
    CONSTRAINT `fk_orders_item_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
