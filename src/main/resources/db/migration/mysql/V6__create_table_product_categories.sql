-- -----------------------------------------------------
-- Table `product_categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product_categories`
(
    `id`                    BIGINT      NOT NULL AUTO_INCREMENT,
    `name`                  VARCHAR(45) NOT NULL,
    `created_at`            TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`            TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `product_categories_id` BIGINT      NULL COMMENT 'Categoría padre. Nulo si es la categoría padre.',
    PRIMARY KEY (`id`),
    INDEX `fk_product_categories_product_categories1_idx` (`product_categories_id` ASC) VISIBLE,
    CONSTRAINT `fk_product_categories_product_categories1`
        FOREIGN KEY (`product_categories_id`)
            REFERENCES `product_categories` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    COMMENT = 'Categoría de productos';
