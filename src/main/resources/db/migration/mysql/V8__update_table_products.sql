DELIMITER //
CREATE PROCEDURE insert_product_images()
BEGIN
    DECLARE done BOOLEAN DEFAULT FALSE;
    DECLARE productId BIGINT;
    DECLARE productImgUrl VARCHAR(255);
    DECLARE c_products CURSOR FOR SELECT id, img_url FROM products;
    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET done = TRUE;

    OPEN c_products;
    c_product:
    LOOP
        FETCH c_products INTO productId, productImgUrl;
        IF done THEN
            LEAVE c_product;
        END IF;
        INSERT INTO product_images (url, products_id) VALUES (productImgUrl, productId);
    END LOOP;
    CLOSE c_products;
END//
DELIMITER ;
CALL insert_product_images();
DROP PROCEDURE insert_product_images;

ALTER TABLE products
    ADD product_categories_id BIGINT NULL;

ALTER TABLE products
    ADD supermarkets_id BIGINT NULL;

CREATE INDEX fk_products_supermarkets1_idx ON products (supermarkets_id);

CREATE INDEX fk_products_product_categories1_idx ON products (product_categories_id);

ALTER TABLE products
    ADD CONSTRAINT fk_products_supermarkets1 FOREIGN KEY (supermarkets_id) REFERENCES supermarkets (id) ON DELETE NO ACTION;

ALTER TABLE products
    ADD CONSTRAINT fk_products_product_categories1 FOREIGN KEY (product_categories_id) REFERENCES product_categories (id) ON DELETE NO ACTION;
