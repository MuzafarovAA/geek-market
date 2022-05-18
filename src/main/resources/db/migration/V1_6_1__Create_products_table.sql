DROP TABLE IF EXISTS products;
CREATE TABLE products
(
    id                BIGINT       NOT NULL AUTO_INCREMENT,
    category_id       BIGINT       NOT NULL,
    vendor_code       VARCHAR(45)  NOT NULL,
    title             VARCHAR(255) NOT NULL,
    short_description VARCHAR(255) NOT NULL,
    full_description  VARCHAR(255) NOT NULL,
    price             DOUBLE       NOT NULL,
    create_at         TIMESTAMP    NOT NULL,
    update_at         TIMESTAMP    NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_products_category_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
