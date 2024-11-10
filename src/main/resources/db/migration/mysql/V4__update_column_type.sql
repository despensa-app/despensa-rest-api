ALTER TABLE products_has_shopping_list
    DROP FOREIGN KEY fk_products_has_shopping_list_shopping_list;
ALTER TABLE products_has_shopping_list
    MODIFY shopping_list_id BIGINT;
ALTER TABLE shopping_list
    MODIFY id BIGINT AUTO_INCREMENT;
ALTER TABLE products_has_shopping_list
    ADD CONSTRAINT fk_products_has_shopping_list_shopping_list
        FOREIGN KEY (shopping_list_id)
            REFERENCES shopping_list (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE products_has_shopping_list
    DROP FOREIGN KEY fk_products_has_shopping_list_unit_types;
ALTER TABLE products_has_shopping_list
    MODIFY unit_type_id BIGINT;
ALTER TABLE unit_types
    MODIFY id BIGINT AUTO_INCREMENT;
ALTER TABLE products_has_shopping_list
    ADD CONSTRAINT fk_products_has_shopping_list_unit_types
        FOREIGN KEY (unit_type_id)
            REFERENCES unit_types (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
