INSERT INTO products(id, name, description, images_url, size, gender, price, created_at, updated_at)
VALUES (1, 'Nike Air Max 270', 'Stylish and comfortable shoes.',
        ARRAY ['https://example.com/nike-air-max-270-1.jpg', 'https://example.com/nike-air-max-270-2.jpg'],
        10, ARRAY ['male'], 150.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (2, 'Adidas Ultraboost 21', 'High-performance running shoes.',
        ARRAY ['https://example.com/adidas-ultraboost-21-1.jpg', 'https://example.com/adidas-ultraboost-21-2.jpg'],
        8, ARRAY ['female'], 180.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (3, 'Puma RS-X', 'Bold retro-inspired sneakers.',
        ARRAY ['https://example.com/puma-rs-x-1.jpg', 'https://example.com/puma-rs-x-2.jpg'],
        9, ARRAY ['male', 'kid'], 110.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       (4, 'Converse All Star', 'Classic unisex sneakers.',
        ARRAY ['https://example.com/converse-all-star-1.jpg', 'https://example.com/converse-all-star-2.jpg'],
        9, ARRAY ['male', 'female'], 60.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO image(id, image_url, product_id)
VALUES (1, 'https://example.com/nike-air-max-270-1.jpg', 1),
       (2, 'https://example.com/nike-air-max-270-2.jpg', 1),
       (3, 'https://example.com/adidas-ultraboost-21-1.jpg', 2),
       (4, 'https://example.com/adidas-ultraboost-21-2.jpg', 2),
       (5, 'https://example.com/puma-rs-x-1.jpg', 3),
       (6, 'https://example.com/puma-rs-x-2.jpg', 3),
       (7, 'https://example.com/converse-all-star-1.jpg', 4),
       (8, 'https://example.com/converse-all-star-2.jpg', 4);


