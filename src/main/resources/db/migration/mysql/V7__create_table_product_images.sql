-- -----------------------------------------------------
-- Table `product_images`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product_images`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `url`         VARCHAR(255) NOT NULL,
    `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `products_id` BIGINT       NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_product_images_products1_idx` (`products_id` ASC) VISIBLE,
    CONSTRAINT `fk_product_images_products1`
        FOREIGN KEY (`products_id`)
            REFERENCES `products` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;
