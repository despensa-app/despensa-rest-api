ALTER TABLE products_has_shopping_list
    ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL;

ALTER TABLE products_has_shopping_list
    ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL;
