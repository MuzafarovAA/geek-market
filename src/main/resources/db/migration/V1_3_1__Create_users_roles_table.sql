DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    INDEX `fk_roles_role_id_idx` (`role_id` ASC) VISIBLE,
    CONSTRAINT `fk_users_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    CONSTRAINT `fk_users_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
