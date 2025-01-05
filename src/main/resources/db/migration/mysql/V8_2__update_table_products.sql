ALTER TABLE products
    MODIFY product_categories_id BIGINT NOT NULL;

ALTER TABLE products
    MODIFY supermarkets_id BIGINT NOT NULL;

ALTER TABLE products
    DROP COLUMN img_url;
