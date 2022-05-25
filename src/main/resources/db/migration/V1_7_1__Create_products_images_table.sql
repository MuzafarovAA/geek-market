DROP TABLE IF EXISTS products_images;
CREATE TABLE products_images
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    product_id BIGINT      NOT NULL,
    path       VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_products_images_product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
