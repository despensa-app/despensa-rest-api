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

INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4562, 'Masa fresca empanada Hacendado', 2.38,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=5bcbe1e7e436244ecafa3faa18fb5c82.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4563, 'Gazpacho suave Hacendado', 1.68,
        'https://placehold.co/1080x1080/0022dd/FFF?text=2fd951e37eee7145095c670c0461bf85.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4564, 'Protegeslip normal Deliplus Suave', 1.95,
        'https://placehold.co/1080x1080/00ffee/FFF?text=d6b64f8d4b115cd1580334916af6ce4d.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4565, 'Cerveza roja sabor intenso', 1.10,
        'https://placehold.co/1080x1080/0000ee/FFF?text=a1387b943a07a3d664278d15bc6fb3ff.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4566, 'Sazonador sabor barbacoa Hacendado', 0.95,
        'https://placehold.co/1080x1080/0088dd/FFF?text=d66841c280ef0fd955a89e1847cdfc1a.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4567, 'Yogur griego stracciatella Hacendado', 1.45,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=cff8259724f48109c0d0e21d17f87565.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4568, 'Sardinas en aceite de oliva Hacendado', 1.30,
        'https://placehold.co/1080x1080/007766/FFF?text=18959a67ee30d45e345b55fc474934cf.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4569, 'Vino tinto D.O Valdepeñas Viña Albali crianza', 2.65,
        'https://placehold.co/1080x1080/00bb55/FFF?text=32d7ea6b6e9f19f1594a31adb9b68c1f.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4570, 'Almejas blancas Cono sur al natural', 2.00,
        'https://placehold.co/1080x1080/0011ff/FFF?text=e3ae9b5f9569854c65221d0f5d08d26d.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4571, 'Alcohol de romero Deliplus', 2.00,
        'https://placehold.co/1080x1080/00ee55/FFF?text=66aa5fcaf78886a11701844639fe9a33.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4572, 'Leche evaporada Hacendado', 1.55,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=9127a811201c8e13e0c163db9d18fcae.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4573, 'Maquillaje Mat Mousse Maybelline 50 sun bronze', 6.95,
        'https://placehold.co/1080x1080/0022dd/FFF?text=49c33b4219027bfbc7ae3f1cf0616715.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4574, 'Coloración permanente sin amoníaco Garnier 9.0 rubio muy claro', 5.90,
        'https://placehold.co/1080x1080/00ffee/FFF?text=dc877d2d38d21531dc29d34553fe6a8a.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4575, 'Natillas sabor coco Hacendado', 0.87,
        'https://placehold.co/1080x1080/0000ee/FFF?text=0348431af5cdc4c893a63f5d90fd219b.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4576, 'Calamar mediano sin limpiar descongelado', 1.25,
        'https://placehold.co/1080x1080/0088dd/FFF?text=487dda8f29a99587487153c0fb51ef54.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4577, 'Almendra natural Hacendado', 2.20,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=eab12e989fccf433a6ef587cd7fdfc87.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4578, 'Comida gato tracto urinário Supreme Compy con pollo y arroz', 4.80,
        'https://placehold.co/1080x1080/007766/FFF?text=4d52c6c95f3e608a915e3d3e47283339.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4579, 'Fideo integral Hacendado', 0.95,
        'https://placehold.co/1080x1080/00bb55/FFF?text=864b0023721c3070732c89eee8eecfb2.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4580, 'Eau de toilette hombre Como tú Viento', 7.00,
        'https://placehold.co/1080x1080/0011ff/FFF?text=37e4d0393eb00019e4f1c42f574bc89f.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4581, 'Café en cápsula doble espresso Hacendado', 3.40,
        'https://placehold.co/1080x1080/00ee55/FFF?text=190bce529bf82244f428a310cbae6a6f.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4582, 'Helado sándwich de nata Hacendado sin azúcares añadidos', 2.20,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=94f8b2a9caddfa1180b983781aec0979.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4583, 'Lomo embuchado Hacendado lonchas', 1.80,
        'https://placehold.co/1080x1080/0022dd/FFF?text=d34fa6180809a1efce045d48d116df0c.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4584, 'Pañales bebé talla 3 de 4-10 kg Deliplus', 4.90,
        'https://placehold.co/1080x1080/00ffee/FFF?text=5ca9aec5edfa1b24c3477c94fc156495.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4585, 'Licor crema de whisky Baileys', 11.99,
        'https://placehold.co/1080x1080/0000ee/FFF?text=ccf055a1eb84dc76ee4acd5eeb10ee24.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4586, 'Cacahuete tostado Hacendado 0% sal añadida', 1.25,
        'https://placehold.co/1080x1080/0088dd/FFF?text=62e51fe7762402463dd92197a5dd75ee.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4587, 'Salsa champiñones Hacendado', 0.80,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=0c47ac0177b86005ea0e908fcbf70c2a.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4588, 'Limpiacristales Bosque Verde', 1.20,
        'https://placehold.co/1080x1080/007766/FFF?text=43f2661210a54fd144d60a70b3f15ec6.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4589, 'Dados de pavo Hacendado', 1.89,
        'https://placehold.co/1080x1080/00bb55/FFF?text=7dcc600ea1f9c3fe9d88645892483ace.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4590, 'Comida gato adulto Compy con ternera y verduras', 2.35,
        'https://placehold.co/1080x1080/0011ff/FFF?text=c4b72a1164c9a38557ebb3278852f9d8.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4591, 'Lágrimas hidratantes para ojos secos', 5.50,
        'https://placehold.co/1080x1080/00ee55/FFF?text=9574c1340da72f0fe1a5022857ab33fe.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4592, 'Tiras de pechuga de pollo al natural Hacendado', 1.89,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=96ad6e195f3cf82ccfc9ff1993266bbd.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4593, 'Helado cucurucho fresa nata', 1.50,
        'https://placehold.co/1080x1080/0022dd/FFF?text=ca0c4435e18a2df25fad2423e3c601e2.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4594, 'Leche entera sin lactosa Hacendado', 4.68,
        'https://placehold.co/1080x1080/00ffee/FFF?text=227bd57e946238d248755f0a097d7a7f.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4595, 'Fideos orientales Yatekomo Gallina Blanca', 1.15,
        'https://placehold.co/1080x1080/0000ee/FFF?text=bc6536a6429d48e7bef84574887980c2.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4596, 'Quitamanchas Oxi Active Bosque Verde en gel', 1.95,
        'https://placehold.co/1080x1080/0088dd/FFF?text=1db940ed3626739aebaf695019b8edb9.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4597, 'Patatas corte fino Hacendado ultracongeladas', 1.05,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=06cf2a9727db0146cfa380c55fc64fd8.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4598, 'Limpiador WC discos de gel activos Lime Zest Pato', 2.90,
        'https://placehold.co/1080x1080/007766/FFF?text=bcb98ca4917cc8b489211bb4685e895f.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4599, 'Lomo de bellota ibérico La Hacienda del ibérico', 46.80,
        'https://placehold.co/1080x1080/00bb55/FFF?text=3fa52013da633e63144f0d7a8450adef.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4600, 'Fibra 24h soluble Deliplus', 5.95,
        'https://placehold.co/1080x1080/0011ff/FFF?text=4a45a16c6a4a511162ec158c5f0454eb.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4601, 'Jamón serrano lonchas', 5.40,
        'https://placehold.co/1080x1080/00ee55/FFF?text=d350092b5a0fdeb11933c5c2b24900a4.webp',
        0.00, '', '2021-09-20 17:38:34', '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4602, 'Rodajas de merluza del cabo Hacendado ultracongeladas', 3.95,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=13b72ef4c82584ba8b496f50af9144b6.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4603, 'Sopa con wonton de langostino y fideos Hacendado ultracongelada', 2.95,
        'https://placehold.co/1080x1080/0022dd/FFF?text=fe443ef62872deb8f0edd699b0fd9903.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4604, 'Piña en su jugo Hacendado rodajas', 1.60,
        'https://placehold.co/1080x1080/00ffee/FFF?text=41b07ae93a3f187939b8a1be552175cb.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4605, 'Almejas blancas Cono sur en salsa gallega', 1.70,
        'https://placehold.co/1080x1080/0000ee/FFF?text=a163a16e749e774b118ecc55b225d2bc.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4606, 'Tarta infantil Frozen II Hacendado congelada', 7.50,
        'https://placehold.co/1080x1080/0088dd/FFF?text=a3bfe4740ceab167570124ef3a761276.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4607, 'Ensaladilla rusa Hacendado', 1.80,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=0e69339a7021c161f199099da215258e.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4608, 'Lacón cortado a mano Noel', 3.12,
        'https://placehold.co/1080x1080/007766/FFF?text=b43982acebaf0bb7179ec5b122964b82.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4609, 'Nata para montar Hacendado', 1.00,
        'https://placehold.co/1080x1080/00bb55/FFF?text=016b6b32c05e1f972273bf8dbf2b2f8a.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4610, 'Bebida de avena Alitey', 0.90,
        'https://placehold.co/1080x1080/0011ff/FFF?text=67d7aec43eda8ac787e8991e38b452c7.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4611, 'Muffin chocolate 3%', 1.00,
        'https://placehold.co/1080x1080/00ee55/FFF?text=de5ec896b000434f87530b5c0f580b7f.webp',
        0.00, '', '2021-09-20 17:38:34', '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4612, 'Refresco Coca-Cola Zero Zero', 0.75,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=82275be98562ea0c11c2e3b903655c63.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4613, 'Pechugas de pollo empanadas marinadas', 4.23,
        'https://placehold.co/1080x1080/0022dd/FFF?text=2df95afeaf72bbbed05d7d82d2a74540.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4614, 'Barritas de barquillo Huesitos bañadas de chocolate con leche', 1.69,
        'https://placehold.co/1080x1080/00ffee/FFF?text=b6fb03ce5b4473151a297dcc81b50356.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4615, 'Alistado pequeño Hacendado congelado', 14.95,
        'https://placehold.co/1080x1080/0000ee/FFF?text=66f7c90c50a6fe34744f07b2e7ef9625.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4616, 'Galletas con mantequilla Hacendado', 1.00,
        'https://placehold.co/1080x1080/0088dd/FFF?text=b5a160c78eeb6f269397435f07419fe6.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4617, 'Café en cápsula descafeinado ristretto L\'Or Espresso', 3.40,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=b21bf76fd4a15df019fe6632d4648851.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4618, 'Queso azul Danés Viking danablu', 1.05,
        'https://placehold.co/1080x1080/007766/FFF?text=768bdeb85ef1c96581268f980f3b066c.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4619, 'Hueso dental para perro Compy', 1.65,
        'https://placehold.co/1080x1080/00bb55/FFF?text=d4525b71d9a0a9b640b4a2c53be17c68.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4620, 'Ajo negro dientes pelados', 3.99,
        'https://placehold.co/1080x1080/0011ff/FFF?text=9a8d3df3dd09d25597976aa12c6ca3f2.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4621, 'Cereales copos de trigo integral y arroz Hacendado 0% azúcares añadidos', 1.70,
        'https://placehold.co/1080x1080/00ee55/FFF?text=4615e69e8275710b7be81f6c101d7292.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4622, 'Pierna de lechal entera congelada', 7.74,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=51c72323faee3bdd8685ee1fedeb097f.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4623, 'Desodorante roll-on hombre invisible Deliplus antimanchas', 0.75,
        'https://placehold.co/1080x1080/0022dd/FFF?text=67923a7175a55103de188b8e6890b949.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4624, 'Vino tinto D.O Vinos de Madrid Condado de Tielmes roble', 3.25,
        'https://placehold.co/1080x1080/00ffee/FFF?text=d8c7d7bb1e084fd0a72bce98396235e2.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4625, 'Escoba Pequeña Bosque Verde', 1.70,
        'https://placehold.co/1080x1080/0000ee/FFF?text=c27c3ca9823db90586f92fc51ca96a19.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4626, 'Sobaos Hacendado', 1.00,
        'https://placehold.co/1080x1080/0088dd/FFF?text=204070fec8264e1a9f3ea8e1850886d3.webp',
        0.00, '', '2021-09-20 17:38:34', '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4627, 'Gasificante repostería casera Hacendado', 0.49,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=9bba9a181a4b6d7e57322ae8774d8877.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4628, 'Estropajo suciedad resistente Bosque Verde', 0.90,
        'https://placehold.co/1080x1080/007766/FFF?text=88b1807b06f051404e76ad52e9a46be4.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4629, 'Bebida energética original Burn', 1.02,
        'https://placehold.co/1080x1080/00bb55/FFF?text=b5b04de72f25d5955653ff14eeb5cce2.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4630, 'Suavizante ropa Floral Bosque Verde concentrado', 1.75,
        'https://placehold.co/1080x1080/0011ff/FFF?text=45c064c1ec68e03e5618d6fd0ed9f506.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4631, 'Yogur sin lactosa Hacendado cremoso, natural y azucarado', 1.30,
        'https://placehold.co/1080x1080/00ee55/FFF?text=0729bc5f93eb9675ce96f3a583eeb6f3.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4632, 'Pudding Hacendado', 1.80,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=a3216a5ec67455ef9528d2b6647ac24d.webp',
        0.00, '', '2021-09-20 17:38:34', '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4633, 'Tarta infantil Miraculous Hacendado congelada', 11.00,
        'https://placehold.co/1080x1080/0022dd/FFF?text=b9b0054199d5530e6d3e3deaf6b03c16.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4634, 'Bases de pizza sin gluten sin lactosa Hacendado ultracongeladas', 3.50,
        'https://placehold.co/1080x1080/00ffee/FFF?text=e9be19632cc72cc19df993fbfa48ba45.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4635, 'Cerveza Corona', 6.00,
        'https://placehold.co/1080x1080/0000ee/FFF?text=62707d0abda54be83f0d149ee5792abe.webp', 0.00,
        '', '2021-09-20 17:38:34', '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4636, 'Sazonador pollo asado Hacendado', 1.05,
        'https://placehold.co/1080x1080/0088dd/FFF?text=6144ffe097fe75b40abccdf52c8bc221.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4637, 'Ambientador automático Lavanda y Jazmín Glade by Brise', 2.69,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=fd55cab89494c4c7b626b81a384df7a0.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4638, 'Desodorante gold Deliplus antimanchas', 1.70,
        'https://placehold.co/1080x1080/007766/FFF?text=c859769b939f68898a4cba0847438eba.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4639, 'Cerveza Especial Steinburg', 3.36,
        'https://placehold.co/1080x1080/00bb55/FFF?text=d346a27dbb7c2f058498b24c016cdac8.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4640, 'Ambientador spray Delicado Bosque Verde', 0.90,
        'https://placehold.co/1080x1080/0011ff/FFF?text=029c75dded4f22c12895fa6fec2bfe82.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4641, 'Pan de molde semillas y pipas de calabaza Hacendado', 1.68,
        'https://placehold.co/1080x1080/00ee55/FFF?text=9c8b4dfbf5977d771c8d60d19790dd9b.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4642, 'Coloración permanente L\'Oréal 1 negro', 6.50,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=fba52faafe490d8c5a94ac6750434033.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4643, 'Muesli Crunchy Hacendado con frutos secos', 1.75,
        'https://placehold.co/1080x1080/0022dd/FFF?text=77f0776fded0ede855f6129cb345b5b3.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4644, 'Pan moño', 1.35, 'https://placehold.co/1080x1080/00ffee/FFF?text=23eb58b2768824dc1b4aa6796327a4eb.webp',
        0.00, '',
        '2021-09-20 17:38:34', '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4645, 'Detergente Lavado a Mano Bosque Verde en polvo', 0.95,
        'https://placehold.co/1080x1080/0000ee/FFF?text=2ea2458f87d1f2bc6093e868e86f9133.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4646, 'Cabecero de lomo Hacendado', 4.32,
        'https://placehold.co/1080x1080/0088dd/FFF?text=a1f159a91a50a0c4591b353bad165f11.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4647, 'Crema facial Textura Rica 24 h Hidrata Deliplus', 5.00,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=b7b79273538624287b702c33e80d8392.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4648, 'Pintalabios mate Superstay matte ink Maybelline 15 lover', 6.60,
        'https://placehold.co/1080x1080/007766/FFF?text=097e4e14301026a6219f1da4a9f7ac22.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4649, 'Patatas fritas onduladas Munchos sabor queso', 1.15,
        'https://placehold.co/1080x1080/00bb55/FFF?text=8658c143f77d02f94afbc9ff9ca0e81b.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4650, 'Eau de toilette mujer Melodía', 3.80,
        'https://placehold.co/1080x1080/0011ff/FFF?text=4f61d3ecc70e13b49b3fe8e1c53b4c69.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4651, 'Quitagrasas KH-7', 3.10,
        'https://placehold.co/1080x1080/00ee55/FFF?text=0b3df0ce55519a2883700d9b68cb6d59.webp',
        0.00, '', '2021-09-20 17:38:34', '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4652, 'Chicle hierbabuena gragea Hacendado', 0.80,
        'https://placehold.co/1080x1080/00ccaa/FFF?text=81daefb5148679cb63ee7c0a4417bc1a.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4653, 'Tacos de vacuno añojo para guisar', 4.73,
        'https://placehold.co/1080x1080/0022dd/FFF?text=d7b9aec1221d13b9bd3787fe734a5b27.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4654, 'Langostino cocido y pelado Pescanova ultracongelado', 3.65,
        'https://placehold.co/1080x1080/00ffee/FFF?text=45dea1216bdc09b024d1a58644c3e72a.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4655, 'Medio conejo a cuartos', 3.97,
        'https://placehold.co/1080x1080/0000ee/FFF?text=c78257cea8470f11c2fb4cdc414084d1.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4656, 'Infusión Jengibre Hacendado', 1.30,
        'https://placehold.co/1080x1080/0088dd/FFF?text=5c5c1f33be0d4bc7a6c8c0cea9cddeac.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4657, 'Bebida láctea semidesnatada con fibra Hacendado', 5.10,
        'https://placehold.co/1080x1080/00ddbb/FFF?text=91928640103e6dc583466aeb2b901cc1.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4658, 'Salsa fresca Setas Hacendado', 1.20,
        'https://placehold.co/1080x1080/007766/FFF?text=cf5b6ae833b53240ab602321211e61e4.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4659, 'Pollo oriental y sémola de trigo con salsa Hacendado', 2.50,
        'https://placehold.co/1080x1080/00bb55/FFF?text=4d3fe298635b1d21969355582fe8cd1f.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4660, 'Pechugas de pollo enteras congeladas', 4.60,
        'https://placehold.co/1080x1080/0011ff/FFF?text=f2790e4e5342f74ccd49bdafbae9c502.webp', 0.00, '',
        '2021-09-20 17:38:34',
        '2021-09-20 17:38:34');
INSERT INTO products (id, name, price, img_url, calories, description, created_at, updated_at)
VALUES (4661, 'Chorizo oreado', 1.94,
        'https://placehold.co/1080x1080/00ee55/FFF?text=d0a50e8a6a132c4c7f6d6ed829ed79e6.webp', 0.00,
        '', '2021-09-20 17:38:34', '2021-09-20 17:38:34');


INSERT INTO unit_types (id, name, created_at, updated_at)
VALUES (1, 'aut', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (2, 'id', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (3, 'qui', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (4, 'aut', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (5, 'libero', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (6, 'est', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (7, 'eaque', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (8, 'dolor', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (9, 'ipsum', '2021-09-03 22:21:06', '2021-09-03 22:21:06'),
       (10, 'vel', '2021-09-03 22:21:06', '2021-09-03 22:21:06')
