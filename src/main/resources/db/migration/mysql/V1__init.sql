-- -----------------------------------------------------
-- Table `products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `products`
(
    `id`          INT                     NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(255)            NOT NULL COMMENT 'Nombre del producto',
    `price`       DECIMAL(11, 2) UNSIGNED NOT NULL COMMENT 'Precio del producto',
    `img_url`     VARCHAR(255)            NOT NULL COMMENT 'Url de la imagen del producto.',
    `calories`    DECIMAL(11, 2) UNSIGNED NOT NULL COMMENT 'Calorías del producto',
    `description` VARCHAR(255)            NULL COMMENT 'Descripción del producto, notas, etc.',
    `created_at`  TIMESTAMP               NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  TIMESTAMP               NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = 'Productos';


-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `users`
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(45)  NOT NULL,
    `password`   VARCHAR(60)  NOT NULL,
    `email`      VARCHAR(100) NULL,
    `created_at` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shopping_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopping_list`
(
    `id`             INT                     NOT NULL AUTO_INCREMENT,
    `name`           VARCHAR(250)            NULL,
    `total_products` INT UNSIGNED            NOT NULL DEFAULT 0 COMMENT 'Número total de productos.',
    `total_calories` DECIMAL(11, 2) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'Total de calorías de todos los productos.',
    `total_price`    DECIMAL(11, 2) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'Precio total de los productos.',
    `user_id`        INT                     NOT NULL,
    `created_at`     TIMESTAMP               NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`     TIMESTAMP               NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `fk_shopping_list_users1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_shopping_list_users1`
        FOREIGN KEY (`user_id`)
            REFERENCES `users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    COMMENT = 'Lista de la compra';

-- -----------------------------------------------------
-- Table `unit_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unit_types`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    COMMENT = 'Tipo de unidad del producto (packs, bricks, botellas, kilos, gramos, latas)';

-- -----------------------------------------------------
-- Table `products_has_shopping_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `products_has_shopping_list`
(
    `product_id`        INT                     NOT NULL,
    `shopping_list_id`  INT                     NOT NULL,
    `unit_type_id`      INT                     NOT NULL,
    `units_per_product` INT UNSIGNED            NOT NULL DEFAULT 1 COMMENT 'Unidades por producto.',
    `total_calories`    DECIMAL(11, 2) UNSIGNED NOT NULL COMMENT 'Total de calorías por unidad.',
    `total_price`       DECIMAL(11, 2) UNSIGNED NOT NULL COMMENT 'Precio total por unidad.',
    `selected`          TINYINT(1)              NOT NULL DEFAULT 0 COMMENT 'Establece si el producto esta seleccionado.',
    PRIMARY KEY (`product_id`, `shopping_list_id`, `unit_type_id`),
    INDEX `fk_products_has_shopping_list_shopping_list_id` (`shopping_list_id` ASC) VISIBLE,
    INDEX `fk_products_has_shopping_list_products_id` (`product_id` ASC) VISIBLE,
    INDEX `fk_products_has_shopping_list_unit_types_id` (`unit_type_id` ASC) VISIBLE,
    CONSTRAINT `fk_products_has_shopping_list_products`
        FOREIGN KEY (`product_id`)
            REFERENCES `products` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_products_has_shopping_list_shopping_list`
        FOREIGN KEY (`shopping_list_id`)
            REFERENCES `shopping_list` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_products_has_shopping_list_unit_types`
        FOREIGN KEY (`unit_type_id`)
            REFERENCES `unit_types` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    COMMENT = 'Relación de productos y lista de la compra.';

-- -----------------------------------------------------
-- Table `settings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `settings`
(
    `id`          INT          NOT NULL AUTO_INCREMENT,
    `key_name`    VARCHAR(45)  NOT NULL,
    `value`       VARCHAR(255) NOT NULL,
    `description` TEXT         NULL,
    `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `key_name_UNIQUE` (`key_name` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- Data init
INSERT INTO users (id, username, password, email, created_at, updated_at)
VALUES (1, 'anonymousUser', 'anonymousUser', 'anonymousUser', '2024-07-07 17:34:12', '2024-07-07 17:34:12');
INSERT INTO unit_types (id, name, created_at, updated_at)
VALUES (1, 'Genérico', '2024-06-01 21:32:13', '2024-06-01 21:32:13');
