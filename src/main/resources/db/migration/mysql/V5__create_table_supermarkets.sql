-- -----------------------------------------------------
-- Table `supermarkets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarkets`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(45)  NOT NULL,
    `logo_url`   VARCHAR(255) NULL,
    `created_at` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;
