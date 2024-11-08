ALTER TABLE products_has_shopping_list
    DROP FOREIGN KEY fk_products_has_shopping_list_products;
ALTER TABLE products_has_shopping_list
    MODIFY product_id BIGINT;
ALTER TABLE products
    MODIFY id BIGINT AUTO_INCREMENT;
ALTER TABLE products_has_shopping_list
    ADD CONSTRAINT `fk_products_has_shopping_list_products`
        FOREIGN KEY (`product_id`)
            REFERENCES `products` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE shopping_list
    DROP FOREIGN KEY fk_shopping_list_users1;
ALTER TABLE shopping_list
    MODIFY user_id BIGINT;
ALTER TABLE users
    MODIFY id BIGINT AUTO_INCREMENT;
ALTER TABLE shopping_list
    ADD CONSTRAINT `fk_shopping_list_users1`
        FOREIGN KEY (`user_id`)
            REFERENCES `users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
