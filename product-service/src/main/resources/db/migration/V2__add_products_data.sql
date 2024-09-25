INSERT INTO products (name, category, description, brand, size, color, price, stock)
VALUES ('Nike Air Zoom Pegasus 38', 'UNISEX', 'High-performance unisex running shoes.', 'Nike', 42, 'Black', 120.00,
        50),
       ('Adidas Ultraboost 21', 'MALE', 'Mens lightweight running shoes with superior cushioning.', 'Adidas', 43, 'White', 180.00, 40),
('Puma RS-X3', 'FEMALE', 'Womens trendy sports shoes with a bold color palette.', 'Puma', 39, 'Pink', 100.00, 30),
       ('Converse Chuck Taylor All Star', 'UNISEX', 'Classic unisex sneakers.', 'Converse', 44, 'Black', 60.00, 100),
       ('New Balance 574', 'KIDS', 'Durable sneakers for children.', 'New Balance', 35, 'Blue', 80.00, 25);

INSERT INTO product_images (image_url, is_main, product_id)
VALUES ('https://example.com/images/nike-air-zoom-pegasus-38-front.jpg', TRUE, 1),
       ('https://example.com/images/nike-air-zoom-pegasus-38-side.jpg', FALSE, 1),
       ('https://example.com/images/nike-air-zoom-pegasus-38-back.jpg', FALSE, 1),
       ('https://example.com/images/adidas-ultraboost-21-front.jpg', TRUE, 2),
       ('https://example.com/images/adidas-ultraboost-21-side.jpg', FALSE, 2),
       ('https://example.com/images/adidas-ultraboost-21-back.jpg', FALSE, 2),
       ('https://example.com/images/converse-chuck-taylor-front.jpg', TRUE, 4),
       ('https://example.com/images/converse-chuck-taylor-side.jpg', FALSE, 4),
       ('https://example.com/images/new-balance-574-front.jpg', TRUE, 5),
       ('https://example.com/images/new-balance-574-side.jpg', FALSE, 5);
