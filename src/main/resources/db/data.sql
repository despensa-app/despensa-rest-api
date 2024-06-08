DELETE
FROM products_has_shopping_list
WHERE product_id > 0;
DELETE
FROM shopping_list
WHERE id > 0;
DELETE
FROM products
WHERE id > 0;
DELETE
FROM unit_types
WHERE id > 0;

INSERT INTO products (name, price, img_url, calories, description, created_at, updated_at)
VALUES ('quis', 6130.74, 'https://placehold.co/1080x1080/00ccaa/FFF?text=laborum', 9405.80,
        'Ut ullam et doloremque dolor maiores velit.', '2021-09-03 22:21:07', '2021-09-03 22:21:07'),
       ('tenetur', 8209.98, 'https://placehold.co/1080x1080/0022dd/FFF?text=vero', 8116.89,
        'Eaque suscipit corporis ipsa nobis.', '2021-09-03 22:21:07', '2021-09-03 22:21:07'),
       ('veniam', 6235.43, 'https://placehold.co/1080x1080/00ffee/FFF?text=ea', 3041.51,
        'Dolores nostrum culpa iste quam voluptatem totam voluptatem veniam.', '2021-09-03 22:21:07',
        '2021-09-03 22:21:07'),
       ('corporis', 1754.00, 'https://placehold.co/1080x1080/0000ee/FFF?text=harum', 8468.64,
        'Et voluptatem corporis quidem qui in sint.', '2021-09-03 22:21:07', '2021-09-03 22:21:07'),
       ('numquam', 6045.10, 'https://placehold.co/1080x1080/0088dd/FFF?text=voluptatum', 289.91,
        'Nemo nostrum fugiat rerum sunt aliquam et enim.', '2021-09-03 22:21:07', '2021-09-03 22:21:07'),
       ('repudiandae', 2005.53, 'https://placehold.co/1080x1080/00ddbb/FFF?text=sit', 4260.63,
        'Aut recusandae voluptas facere iusto.', '2021-09-03 22:21:07', '2021-09-03 22:21:07'),
       ('ut', 8467.95, 'https://placehold.co/1080x1080/007766/FFF?text=impedit', 8805.64,
        'Quia distinctio est mollitia et voluptatem.', '2021-09-03 22:21:07', '2021-09-03 22:21:07'),
       ('dolores', 598.80, 'https://placehold.co/1080x1080/00bb55/FFF?text=ad', 9775.01,
        'Rerum id incidunt corporis sint pariatur ex.', '2021-09-03 22:21:07', '2021-09-03 22:21:07'),
       ('nemo', 7440.91, 'https://placehold.co/1080x1080/0011ff/FFF?text=eligendi', 7841.38,
        'Omnis quidem molestiae corporis ut incidunt iusto libero.', '2021-09-03 22:21:07', '2021-09-03 22:21:07'),
       ('aut', 8402.55, 'https://placehold.co/1080x1080/00ee55/FFF?text=dignissimos', 518.30,
        'Maiores est temporibus temporibus ut aut maiores qui.', '2021-09-03 22:21:07', '2021-09-03 22:21:07');

INSERT INTO unit_types (name, created_at, updated_at)
VALUES ('aut', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('id', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('qui', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('aut', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('libero', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('est', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('eaque', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('dolor', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('ipsum', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       ('vel', '2021-09-03 22:21:06', '2021-09-03 22:21:06')
